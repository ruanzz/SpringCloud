package com.ruanzz.service.item.controller;

import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.service.ItemBrandService;
import com.ruanzz.service.item.vo.ItemBrandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品品牌REST入口
 */
@Api(value = "/brand", tags = "商品品牌模块")
@RestController
@RequestMapping("brand")
public class BrandController {

  @Autowired
  private ItemBrandService itemBrandService;


  @ApiOperation(value = "获取商品品牌列表", notes = "支持分页查询，支持名称模糊查询")
  @GetMapping("/list")
  public ResponseEntity<PageResult<ItemBrandVO>> queryBrandByPage(
      @RequestParam(value = "page", defaultValue = "1") Integer page,
      @RequestParam(value = "rows", defaultValue = "5") Integer rows,
      @RequestParam(value = "sortBy", required = false) String sortBy,
      @RequestParam(value = "desc", defaultValue = "false") boolean desc,
      @RequestParam(value = "key", required = false) String key
  ) {
    return ResponseEntity.ok(itemBrandService.queryBrandByPage(page, rows, sortBy, desc, key));
  }

  @PostMapping
  public ResponseEntity<Void> addBrand(@RequestBody ItemBrandVO brand) {
    itemBrandService.addBrand(brand);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }


}
