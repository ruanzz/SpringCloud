package com.ruanzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ruanzz
 * @date 2019/1/12
 * @description ItemService 启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class ItemServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(ItemServiceApp.class, args);
  }
}
