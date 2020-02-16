##自定义Starter

#####[Step1]
新建Maven项目，在项目的POM文件中定义使用的依赖；

#####[Step2]
新建配置类，写好配置项和默认的配置值，指明配置项前缀；

#####[Step3]
新建自动装配类，使用@Configuration和@Bean来进行自动装配；

#####[Step4]
新建spring.factories文件，指定Starter的自动装配类；
