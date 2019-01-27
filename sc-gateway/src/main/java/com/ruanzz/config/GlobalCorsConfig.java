package com.ruanzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description 配置CORS
 */
@Configuration
public class GlobalCorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();

    //允许的域,不要写*，否则cookie就无法使用了
    config.addAllowedOrigin("http://manage.sc.com");
    config.addAllowedOrigin("http://www.sc.com");

    //是否发送Cookie信息
    config.setAllowCredentials(true);

    //允许的请求方式
    config.addAllowedMethod("OPTIONS");
    config.addAllowedMethod("HEAD");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("DELETE");
    config.addAllowedMethod("PATCH");
    config.setMaxAge(3600L);

    //允许的头信息
    config.addAllowedHeader("*");

    //添加映射路径，拦截一切请求
    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    configSource.registerCorsConfiguration("/**", config);

    return new CorsFilter(configSource);
  }
}
