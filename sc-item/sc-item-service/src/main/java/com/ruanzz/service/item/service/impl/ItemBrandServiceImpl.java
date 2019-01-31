package com.ruanzz.service.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanzz.common.utils.ListUtil;
import com.ruanzz.common.utils.StringUtil;
import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.mapper.ItemBrandMapper;
import com.ruanzz.service.item.pojo.ItemBrand;
import com.ruanzz.service.item.service.ItemBrandService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品品牌Service接口实现类
 */
@Service
public class ItemBrandServiceImpl implements ItemBrandService {

  @Autowired
  private ItemBrandMapper itemBrandMapper;

  @Override
  public PageResult<ItemBrand> queryBrandByPage(Integer page, Integer rows, String sortBy,
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

    if (ListUtil.isEmpty(itemBrandList)) {
      itemBrandList = new ArrayList<>();
    }
    PageInfo<ItemBrand> pageInfo = new PageInfo<>(itemBrandList);

    return new PageResult<>(pageInfo.getTotal(), itemBrandList);
  }
}
