package com.ruanzz;

import com.ruanzz.scheduler.Scheduler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhenzhuo.Ruan
 */
@SpringBootApplication
@RestController
@RequestMapping("/schedule")
public class SchedulerApplication {

  @Autowired
  Scheduler scheduler;

  public static void main(String[] args) {
    SpringApplication.run(SchedulerApplication.class, args);
  }


  @PostMapping
  public List<VmVO> scheduleVm(@RequestBody List<VmVO> vms) {
    return scheduler.schedule(vms);
  }

}
