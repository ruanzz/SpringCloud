package com.ruanzz.service.item.controller;

import com.ruanzz.common.utils.MapUtil;
import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.pojo.ItemBrand;
import com.ruanzz.service.item.service.ItemBrandService;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description TODO
 */
@RestController
@RequestMapping("brand")
public class BrandController {

  @Autowired
  private ItemBrandService itemBrandService;

  public ResponseEntity<PageResult<ItemBrand>> queryBrandByParam(HttpServletRequest request) {

    Map<String, String[]> map = request.getParameterMap();
    Map<String, Object> param = new HashMap<>();
    Integer page = (Integer) MapUtil.getValue(param, "page");
    if (Objects.isNull(page)) {
      page = 1;
    }
    param.put("page", page);
    Integer rows = (Integer) MapUtil.getValue(param, "rows");
    if (Objects.isNull(rows)) {
      rows = 5;
    }
    param.put("rows", rows);
    return ResponseEntity.ok(itemBrandService.queryBrandByParam(param));
  }
}
