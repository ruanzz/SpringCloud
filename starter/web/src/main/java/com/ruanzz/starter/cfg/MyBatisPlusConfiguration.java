package com.ruanzz.starter.cfg;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhenzhuo.Ruan
 */
@Configuration
@ConditionalOnBean(MybatisSqlSessionFactoryBean.class)
@AutoConfigureAfter(MybatisPlusAutoConfiguration.class)
public class MyBatisPlusConfiguration {

}
