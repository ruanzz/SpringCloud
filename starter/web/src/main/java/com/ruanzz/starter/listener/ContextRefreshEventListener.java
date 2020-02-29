package com.ruanzz.starter.listener;

import com.ruanzz.starter.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Zhenzhuo.Ruan
 */
@Component
public class ContextRefreshEventListener {

  @EventListener
  public void handleContextRefreshEvent(ContextRefreshedEvent event) {
    ApplicationContext applicationContext = event.getApplicationContext();
    ApplicationContextUtil.setApplicationContext(applicationContext);
  }
}
