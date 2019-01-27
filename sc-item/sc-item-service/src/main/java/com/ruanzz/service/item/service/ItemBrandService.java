package com.ruanzz.service.item.service;

import com.ruanzz.common.vo.PageResult;
import com.ruanzz.service.item.pojo.ItemBrand;
import java.util.Map;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 商品品牌Service接口
 */
public interface ItemBrandService {

  public PageResult<ItemBrand> queryBrandByParam(Map<String, Object> param);
}
