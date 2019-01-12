package com.ruanzz.service.item.controller;

import com.ruanzz.common.utils.JsonUtil;
import com.ruanzz.service.item.vo.OrderVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruanzz
 * @date 2019/1/12
 * @description ItemController
 */
@RestController
@RequestMapping("/item")
public class ItemController {

  @GetMapping("/test")
  public ResponseEntity<OrderVO> test() {
    OrderVO orderVO = new OrderVO("10000");
    String json = JsonUtil.toJSON(orderVO);
    System.out.println(json);
    return ResponseEntity.ok(orderVO);
  }

}
