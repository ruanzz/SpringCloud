package com.ruanzz.service.item.pojo;

import com.ruanzz.common.pojo.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author ruanzz
 * @date 2019/2/1
 * @description 商品品牌分类关系表
 */

@Data
@Entity
@Table(name = "ITEM_BRAND_CATEGORY_REL")
public class ItemBrandCategoryRel extends BaseEntity {

  @Column(name = "CATEGORY_UUID_")
  private String categoryUuid;

  @Column(name = "BRAND_UUID_")
  private String brandUuid;

}
