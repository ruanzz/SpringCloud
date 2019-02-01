package com.ruanzz.common._enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 异常枚举
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ExceptionEnum {
  BRAND_SAVE_ERROR(500, "保存商品品牌失败");
  int status;
  String msg;
}
