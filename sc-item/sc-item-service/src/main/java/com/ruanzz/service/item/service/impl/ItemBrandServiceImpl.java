package com.ruanzz.service.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanzz.common.utils.ListUtil;
import com.ruanzz.common.utils.MapUtil;
import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.mapper.ItemBrandMapper;
import com.ruanzz.service.item.pojo.ItemBrand;
import com.ruanzz.service.item.service.ItemBrandService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

  /**
   * 根据参数查询，提供分页
   */
  public PageResult<ItemBrand> queryBrandByParam(Map<String, Object> param) {
    PageHelper.startPage(param);
    Example example = new Example(ItemBrand.class);
    String key = (String) MapUtil.getValue(param, "key");
    if (!Objects.isNull(key)) {
      example.createCriteria().orLike("name", "%" + key + "%");
    }
    String sortBy = (String) MapUtil.getValue(param, "sortBy");
    if (!Objects.isNull(sortBy)) {
      Boolean desc = (Boolean) MapUtil.getValue(param, "desc");
      if (Objects.isNull(desc)) {
        desc = false;
      } else {
        desc = desc.booleanValue();
      }
      String sortByClause = sortBy + (desc ? " DESC" : " ASC");
      example.setOrderByClause(sortByClause);
    }
    List<ItemBrand> itemBrandList = itemBrandMapper.selectByExample(example);
    if (ListUtil.isEmpty(itemBrandList)) {
      itemBrandList = new ArrayList<>();
    }
    PageInfo<ItemBrand> pageInfo = new PageInfo<>();
    return new PageResult(pageInfo.getTotal(), itemBrandList);
  }
}
