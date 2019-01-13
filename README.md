# SpringCloud
[![Build Status](https://www.travis-ci.org/ruanzz/SpringCloud.svg?branch=master)](https://www.travis-ci.org/ruanzz/SpringCloud)

## 注册中心服务
 使用eureka注册中心服务，端口使用8081
 
## 网关
 使用zuul作为网关层，端口使用8082
 
## 接口文档
 swagger生成文档，在网关节点对所有微服务接口做了整合,接口地址:http://127.0.0.1:8082/swagger-ui.html

## 商品微服务模块
  是一个单独模块，可以拿出来单独部署，这里为了方便做持续集成，当做聚合工程的一个模块了
  商品微服务模块有两个子模块，一个是接口，一个是服务实现
