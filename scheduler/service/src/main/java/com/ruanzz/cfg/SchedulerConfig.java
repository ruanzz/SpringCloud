package com.ruanzz.cfg;

import com.ruanzz.scheduler.DefaultVmScheduler;
import com.ruanzz.scheduler.Scheduler;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhenzhuo.Ruan
 */
@Configuration
@EnableConfigurationProperties(SchedulerProperties.class)
public class SchedulerConfig {

  @Autowired
  SchedulerProperties schedulerProperties;

  @Bean
  public Scheduler scheduler() {
    for (Entry<String, Scheduler> entry : SchedulerProperties.schedulerMap.entrySet()) {
      if (entry.getKey().equals(schedulerProperties.getScheduler())) {
        return entry.getValue();
      }
    }
    return new DefaultVmScheduler();
  }
}
