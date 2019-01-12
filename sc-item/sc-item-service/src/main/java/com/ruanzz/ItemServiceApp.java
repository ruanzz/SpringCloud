package com.ruanzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ruanzz
 * @date 2019/1/12
 * @description ItemService 启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ItemServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(ItemServiceApp.class, args);
  }
}
