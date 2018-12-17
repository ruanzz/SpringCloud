package com.ruanzz.pojo;

import lombok.Data;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 商品实体类
 */
@Data
public class Item {

  private Integer id;
  private String name;
  private Long price;
}
