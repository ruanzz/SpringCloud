package com.ruanzz.starter.util;

import org.springframework.context.ApplicationContext;

/**
 * @author Zhenzhuo.Ruan
 */
public class ApplicationContextUtil {

  private static ApplicationContext applicationContext;

  public static void setApplicationContext(ApplicationContext context) {
    applicationContext = context;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }


}
