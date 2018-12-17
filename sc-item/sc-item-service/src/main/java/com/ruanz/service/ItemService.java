package com.ruanz.service;

import com.ruanzz.pojo.Item;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description item Service层
 */
@Service
public class ItemService {

  public Item saveItem(Item item) {
    int id = new Random().nextInt(100);
    item.setId(id);
    return item;
  }

}
