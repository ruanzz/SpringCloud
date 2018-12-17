package com.ruanz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 商品服务 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ItemServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(ItemServiceApp.class, args);
  }
}
