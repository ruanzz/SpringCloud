package com.ruanzz.service.item.controller;

import com.ruanzz.service.item.pojo.ItemCategory;
import com.ruanzz.service.item.service.ItemCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruanzz
 * @date 2019/1/13
 * @description 商品分类REST 入口
 */
@RestController
@RequestMapping("category")
public class CategoryController {

  @Autowired
  private ItemCategoryService itemCategoryService;

  @GetMapping("list")
  public ResponseEntity<List<ItemCategory>> queryCategoryListByParentId(
      @RequestParam("pid") Long parentId) {
    return ResponseEntity.ok(itemCategoryService.queryCategoryListByParentId(parentId));
  }

}
