package com.ruanzz.service.item.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品描述
 */
@Entity
@Table(name = "ITEM_BRAND")
@Data
public class ItemBrand {

  @Id
  @Column(name = "ID_")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME_")
  private String name;

}
