package com.ypy.springinactionnine;

import com.ypy.springinactionnine.async.Jeep;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * 知识点2：@EnableAsync:开启新特性：启用异步执行功能
 * 需要和@Async注解一起使用，才能开启异步执行的新特性
 *
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.ypy.springinactionnine.async"})
public class App2 {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App2.class,args);
        configurableApplicationContext.getBean(Runnable.class).run();
        System.out.println("----------end----------");
//        configurableApplicationContext.close();
    }

}
