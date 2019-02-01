package com.ruanzz.service.item.service;

import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.vo.ItemBrandVO;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品品牌Service接口
 */
public interface ItemBrandService {

  /**
   * 查询品牌
   */
  PageResult<ItemBrandVO> queryBrandByPage(Integer page, Integer rows, String sortBy, boolean desc,
      String key);

  /**
   * 保存品牌
   */
  void addBrand(ItemBrandVO brandVO);
}
