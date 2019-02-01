package com.ruanzz.service.item.pojo;

import com.ruanzz.common.pojo.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品品牌
 */
@Entity
@Table(name = "ITEM_BRAND")
@Data
public class ItemBrand extends BaseEntity {

  @Column(name = "NAME_")
  private String name;
}
