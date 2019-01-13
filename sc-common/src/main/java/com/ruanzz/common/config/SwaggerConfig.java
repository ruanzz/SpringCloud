package com.ruanzz.common.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ruanzz
 * @date 2019/1/12
 * @description swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.ruanzz"))
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Swagger-API文档")
        .description("Swagger接入教程")
        .termsOfServiceUrl("http://127.0.0.1:8080")
        .version("1.0")
        .contact(new Contact("Ryan", "https://www.github.com/ruanzz", "rzz1995@live.com"))
        .build();
  }

  @Bean
  UiConfiguration uiConfig() {
    return new UiConfiguration(null, "list", "alpha", "schema",
        UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
  }

}
