package com.ypy.springbootinactiontwentythree.twentythreeactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * 知识点3：自定义info信息的学习
 * （1）访问地址：http://127.0.0.1:8080/actuator/info
 * （2）自定义info的监控 和对git的监控 详见git.properties
 */
@SpringBootApplication
@PropertySource(value = "classpath:git.properties")
public class App3 {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App3.class,args);
        System.out.println(configurableApplicationContext);
    }

}
