package com.ypy.springinactionnine;

import com.ypy.springinactionnine.properties.TomcatProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 知识点1：开启新特性：从配置文件中读取属性值，加载到Bean
 * @EnableConfigurationProperties：开启新特性 ：从配置文件中读取属性值，注入到Bean中
 * 需要结合@ConfigurationProperties注解一起使用
 */
//@SpringBootApplication(scanBasePackages = {"com.ypy.springinactionnine.properties"})
//@EnableAutoConfiguration // 开启新特性，可以自动加载所有的配置文件
@EnableConfigurationProperties // 开启新特性：从配置文件中，读取属性值注入到Bean
@ComponentScan(basePackages = "com.ypy.springinactionnine.properties")
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);
        System.out.println(configurableApplicationContext.getBean(TomcatProperties.class));
        configurableApplicationContext.close();
    }

}
