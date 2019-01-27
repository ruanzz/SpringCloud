package com.ruanzz.service.item.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * @author ruanzz
 * @date 2019/1/13
 * @description 商品分类
 */
@Data
@NoArgsConstructor
@Table(name = "ITEM_CATEGORY")
@Entity
public class ItemCategory {

  @Id
  @Column(name = "ID_")
  @KeySql(useGeneratedKeys = true)
  private Long id;

  @Column(name = "PARENT_ID_")
  private Long parentId;


}
