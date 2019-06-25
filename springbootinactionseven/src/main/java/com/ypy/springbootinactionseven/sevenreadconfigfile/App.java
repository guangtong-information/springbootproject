package com.ypy.springbootinactionseven.sevenreadconfigfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionseven.sevenreadconfigfile.environmentpostprocessor"})
public class App {

    public static void main(String[] args) {
        // 知识点1：统一配置中心的原型
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("password"));
        configurableApplicationContext.close();
    }

}
