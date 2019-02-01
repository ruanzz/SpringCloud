package com.ruanzz.service.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanzz.common._enum.ExceptionEnum;
import com.ruanzz.common.exception.AppException;
import com.ruanzz.common.utils.ListUtil;
import com.ruanzz.common.utils.StringUtil;
import com.ruanzz.common.utils.UuidUtil;
import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.mapper.ItemBrandCategoryRelMapper;
import com.ruanzz.service.item.mapper.ItemBrandMapper;
import com.ruanzz.service.item.pojo.ItemBrand;
import com.ruanzz.service.item.pojo.ItemBrandCategoryRel;
import com.ruanzz.service.item.service.ItemBrandService;
import com.ruanzz.service.item.vo.ItemBrandVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品品牌Service接口实现类
 */
@Service
@Slf4j
public class ItemBrandServiceImpl implements ItemBrandService {

  @Autowired
  private ItemBrandMapper itemBrandMapper;

  @Autowired
  private ItemBrandCategoryRelMapper itemBrandCategoryRelMapper;

  @Override
  public PageResult<ItemBrandVO> queryBrandByPage(Integer page, Integer rows, String sortBy,
      boolean desc,
      String key) {

    // 开启分页
    PageHelper.startPage(page, rows);

    // 过滤
    Example example = new Example(ItemBrand.class);
    if (StringUtil.isNotEmpty(key)) {
      example.createCriteria().orLike("name", "%" + key + "%");
    }

    //排序
    if (StringUtil.isNotEmpty(sortBy)) {
      String sortByClause = sortBy + (desc ? " DESC" : " ASC");
      example.setOrderByClause(sortByClause);
    }

    List<ItemBrand> itemBrandList = itemBrandMapper.selectByExample(example);

    List<ItemBrandVO> result = convertToVO(itemBrandList);
    PageInfo<ItemBrandVO> pageInfo = new PageInfo<>(result);

    return new PageResult<>(pageInfo.getTotal(), result);
  }

  /**
   * VO转换
   */
  private List<ItemBrandVO> convertToVO(List<ItemBrand> itemBrandList) {
    List<ItemBrandVO> list = new ArrayList<>();
    if (ListUtil.isEmpty(itemBrandList)) {
      return list;
    }
    for (ItemBrand brand : itemBrandList) {
      ItemBrandVO vo = new ItemBrandVO();
      vo.setName(brand.getName());
      vo.setUuid(brand.getUuid());
      list.add(vo);
    }
    return list;
  }

  @Transactional
  @Override
  public void addBrand(ItemBrandVO brandVO) {
    ItemBrand brand = convertToEntity(brandVO);
    int insertRows = itemBrandMapper.insert(brand);
    if (insertRows == 0) {
      log.error("保存商品品牌失败，插入数据库出错，实体信息:{}", brand);
      throw new AppException(ExceptionEnum.BRAND_SAVE_ERROR);
    }

    //添加品牌分类关系
    List<String> cids = brandVO.getCids();
    if (ListUtil.isNotEmpty(cids)) {
      for (String cid : cids) {
        ItemBrandCategoryRel rel = new ItemBrandCategoryRel();
        rel.setBrandUuid(brand.getUuid());
        rel.setCategoryUuid(cid);
        rel.setUuid(UuidUtil.getDbUuid());
        rel.setCreateTime(new Date());
        rel.setUpdateTime(rel.getCreateTime());
        int insertResult = itemBrandCategoryRelMapper.insert(rel);
        if (insertResult == 0) {
          log.info("保存商品品牌和分类关系失败，插入数据库出错，categoryUuid:{},brandUuid:{}", cid, brand.getUuid());
          throw new AppException(ExceptionEnum.BRAND_SAVE_ERROR);
        }
      }
    }
  }

  /**
   * VO转换为数据库实体
   */
  private ItemBrand convertToEntity(ItemBrandVO brand) {
    ItemBrand entity = new ItemBrand();
    entity.setUuid(UuidUtil.getDbUuid());
    entity.setName(brand.getName());
    entity.setCreateTime(new Date());
    entity.setUpdateTime(entity.getCreateTime());
    // 保存数据库转换强制设值为null
    entity.setId(null);
    return entity;
  }
}

