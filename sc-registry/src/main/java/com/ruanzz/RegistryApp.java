package com.ruanzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description Registry 启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApp {

  public static void main(String[] args) {
    SpringApplication.run(RegistryApp.class, args);
  }
}
