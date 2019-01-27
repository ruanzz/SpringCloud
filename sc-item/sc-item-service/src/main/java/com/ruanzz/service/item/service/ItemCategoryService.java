package com.ruanzz.service.item.service;

import com.ruanzz.service.item.mapper.ItemCategoryMapper;
import com.ruanzz.service.item.pojo.ItemCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ruanzz
 * @date 2019/1/13
 * @description 商品分类Service
 */
@Service
public class ItemCategoryService {

  @Autowired
  private ItemCategoryMapper itemCategoryMapper;

  public List<ItemCategory> queryCategoryListByParentId(Long parentId) {
    ItemCategory category = new ItemCategory();
    category.setParentId(1L);
    return itemCategoryMapper.select(category);
  }
}
