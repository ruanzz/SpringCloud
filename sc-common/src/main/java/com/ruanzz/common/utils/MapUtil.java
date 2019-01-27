package com.ruanzz.common.utils;

import java.util.Map;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description Map工具类
 */
public class MapUtil {

  /**
   * 判断一个Map中是否含有key，并且value不为空
   */
  public static boolean hasKey(Map map, Object key) {
    if (!map.containsKey(key)) {
      return false;
    }
    Object obj = map.get(key);
    if (obj == null) {
      return false;
    }
    if (obj instanceof String && StringUtil.isEmpty(obj.toString())) {
      return false;
    }
    return true;
  }


  public static Object getValue(Map map, Object key) {
    if (hasKey(map, key)) {
      return map.get(key);
    }
    return null;
  }
}
