package com.ruanzz.common.utils;

import java.util.UUID;

/**
 * @author ruanzz
 * @date 2019/2/1
 * @description UUID工具类
 */
public class UuidUtil {

  public static String getDbUuid() {
    return UUID.randomUUID().toString();
  }

  public static void main(String[] args) {
    System.out.println(UuidUtil.getDbUuid());
  }
}
