package com.ruanzz.common.utils;

import java.util.Collection;
import org.springframework.util.CollectionUtils;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description List工具类
 */
public class ListUtil {

  /**
   * 判断集合是否为空
   */
  public static boolean isEmpty(Collection c) {
    return CollectionUtils.isEmpty(c);
  }

  /**
   * 判断集合非空
   */
  public static boolean isNotEmpty(Collection c) {
    return !isEmpty(c);
  }

}
