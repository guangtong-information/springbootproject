package com.ypy.springbootinactiontwentythree.twentythreeactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * 知识点1：搭建springboot监控和度量的环境
 * （1）引入依赖配置
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-actuator</artifactId>
 *         </dependency>
 * （2）开启端点监控：application.yml开启【重要】
 *  # springboot监控端点的配置
 * management:
 *   endpoint:
 *     web:
 *       exposure:
 *         include: "*" # *代表启用所有的监控端点，默认情况下，这些端点都是被禁用的
 *（3）访问地址：http://127.0.0.1:8080/actuator/
 *（4）注意：谷歌浏览器中安装JsonView扩展程序【以便按照Json样式显示Json字符串】
 *（5）具体的监控点说明：
 *      http://127.0.0.1:8080/actuator/beans 容器中的Bean对象
 *      http://127.0.0.1:8080/actuator/env 所有的配置文件
 *          --@PropertySource(value = "classpath:my.properties") 配置一个自定义的配置文件
 *          --包括application.yml 二个配置文件，都会在--http://127.0.0.1:8080/actuator/env中显示
 *      http://127.0.0.1:8080/actuator/mappings URL映射
 *      http://127.0.0.1:8080/actuator/conditions autoconfig自动化的配置信息
 *（6）源码：spring-boot-actuator.jar
 */
@PropertySource(value = "classpath:my.properties")
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactiontwentythree.twentythreeactuator.controller"})
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
    }

}
