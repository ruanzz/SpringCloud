package com.ruanzz.service.item.controller;

import com.ruanzz.common._enum.ExceptionEnum;
import com.ruanzz.common.exception.BaseException;
import com.ruanzz.common.utils.JsonUtil;
import com.ruanzz.service.item.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruanzz
 * @date 2019/1/12
 * @description ItemController
 */
@Api(value = "/item", tags = "商品模块")
@RestController
@RequestMapping("/item")
public class ItemController {

  @ApiOperation(value = "商品模块测试异常AOP处理", notes = "不知道写啥的note")
  @GetMapping("/test")
  public ResponseEntity<OrderVO> test() {
    OrderVO orderVO = new OrderVO("10000");
    System.out.println(JsonUtil.toJSON(orderVO));
    try {
      int i = 1 / 0;
    } catch (Exception e) {
      throw new BaseException(ExceptionEnum.GOODS_SAVE_ERROR);
    }

    return ResponseEntity.ok(orderVO);
  }

}
