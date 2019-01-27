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
 * @date 2019/1/13
 * @description 商品分类
 */
@Data
@Entity
@Table(name = "ITEM_CATEGORY")
public class ItemCategory {

  @Id
  @Column(name = "ID_")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "PARENT_ID_")
  private Long parentId;


}
