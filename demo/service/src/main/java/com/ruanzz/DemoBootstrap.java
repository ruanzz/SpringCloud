package com.ruanzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhenzhuo.Ruan
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoBootstrap {

  public static void main(String[] args) {
    SpringApplication.run(DemoBootstrap.class, args);
  }

}
