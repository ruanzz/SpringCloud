package com.ruanzz.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description String工具类
 */
public class StringUtil {

  /**
   * 判断字符串是否为空
   */
  public static boolean isEmpty(CharSequence cs) {
    return StringUtils.isEmpty(cs);
  }

  /**
   * 判断字符串是否为非空
   */
  public static boolean isNotEmpty(CharSequence cs) {
    return !isEmpty(cs);
  }

}
