package com.ruanzz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 网关 启动类
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableSwagger2
public class GatewayApp {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApp.class, args);
  }
}
