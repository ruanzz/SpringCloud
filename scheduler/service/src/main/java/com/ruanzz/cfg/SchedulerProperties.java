package com.ruanzz.cfg;

import com.ruanzz.scheduler.DefaultVmScheduler;
import com.ruanzz.scheduler.Scheduler;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Zhenzhuo.Ruan
 */
@ConfigurationProperties(prefix = "sc")
public class SchedulerProperties {

  static Map<String, Scheduler> schedulerMap = new HashMap<>();

  static {
    schedulerMap.put("default", new DefaultVmScheduler());
  }

  @Value("${sc.scheduler}")
  private String scheduler;


  public String getScheduler() {
    return scheduler;
  }
}
