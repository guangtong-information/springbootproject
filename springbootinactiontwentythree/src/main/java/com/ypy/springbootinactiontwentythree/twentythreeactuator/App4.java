package com.ypy.springbootinactiontwentythree.twentythreeactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点4：度量metrics的使用
 * http://127.0.0.1:8080/actuator/metrics
 * http://localhost:8080/actuator/metrics/jvm.memory.max 通过访问具体的值实现数据的度量
 */
@SpringBootApplication
public class App4 {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App4.class,args);
        System.out.println(configurableApplicationContext);
    }
}

