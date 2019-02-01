package com.ruanzz.service.item.pojo;

import com.ruanzz.common.pojo.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class ItemCategory extends BaseEntity {

  @Column(name = "PARENT_ID_")
  private Long parentId;


}
