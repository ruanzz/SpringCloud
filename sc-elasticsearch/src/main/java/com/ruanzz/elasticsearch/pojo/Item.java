package com.ruanzz.elasticsearch.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author ruanzz
 * @date 2019/2/5
 * @description ES实体类
 */
@Data
@Document(indexName = "es", type = "item", shards = 1, replicas = 3)
public class Item {

  @Id
  @Field(type = FieldType.Long)
  private Long id;
  /**
   * 标题
   */
  @Field(type = FieldType.Text)
  private String title;
  /**
   * 分类
   */
  @Field(type = FieldType.Keyword)
  private String category;
  /**
   * 品牌
   */
  @Field(type = FieldType.Keyword)
  private String brand;
  /**
   * 价格
   */
  @Field(type = FieldType.Double)
  private Double price;
  /**
   * 图片地址
   */
  @Field(type = FieldType.Keyword, index = false)
  private String images;

}
