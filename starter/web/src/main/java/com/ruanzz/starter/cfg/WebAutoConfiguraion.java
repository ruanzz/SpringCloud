package com.ruanzz.starter.cfg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Zhenzhuo.Ruan
 */
@Configuration
@Slf4j
@ConditionalOnWebApplication
@EnableConfigurationProperties(WebProperties.class)
@Import(MyBatisPlusConfiguration.class)
public class WebAutoConfiguraion implements InitializingBean {

  @Autowired
  WebProperties prop;


  /**
   * Invoked by a BeanFactory after it has set all bean properties supplied (and satisfied
   * BeanFactoryAware and ApplicationContextAware).
   * <p>This method allows the bean instance to perform initialization only
   * possible when all bean properties have been set and to throw an exception in the event of
   * misconfiguration.
   *
   * @throws Exception in the event of misconfiguration (such as failure to set an essential
   * property) or if initialization fails.
   */
  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("WebAutoConfiguraion set prop done!");
  }
}
