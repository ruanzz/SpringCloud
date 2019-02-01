package com.ruanzz.service.item.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @author ruanzz
 * @date 2019/2/1
 * @description 商品品牌VO
 */
@Data
public class ItemBrandVO implements Serializable {

  private String uuid;
  private String name;
  private List<String> cids;
}
