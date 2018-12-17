package com.ruanz.web;

import com.ruanz.service.ItemService;
import com.ruanzz.common._enum.ExceptionEnum;
import com.ruanzz.common.exception.BaseException;
import com.ruanzz.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description item Controller
 */
@RestController
@RequestMapping("/item")
public class ItemController {

  @Autowired
  private ItemService itemService;

  @PostMapping
  public ResponseEntity<Item> saveItem(Item item) {
    // 校验价格，不符合的抛出错误
    if (item.getPrice() == null) {
      throw new BaseException(ExceptionEnum.GOODS_SAVE_PRICE_NOT_NULL);
    }
    try {
      item = itemService.saveItem(item);
    } catch (Exception e) {
      throw new BaseException(ExceptionEnum.GOODS_SAVE_ERROR);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(item);
  }
}
