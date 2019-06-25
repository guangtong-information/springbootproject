package com.ypy.springbootinactionseven.sevenreadconfigfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点2：profiles的使用
 * （1）类似于Autoconfig
 * （2）激活的方式有多种，可以使用硬编码、或者启动参数配置、或者配置文件定义
 * （3）默认的配置文件（application.properties）总是会被加载
 *
 * 激活的方式有三种：
 * 第一种：使用硬编码（不推荐）
 * 第二种：使用启动参数配置（不推荐）
 * 第三种：在默认的配置文件中，配置激活（推荐）
 */
@SpringBootApplication
public class App2 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App2.class);
        // 方式一：使用硬编码（不推荐）
//        springApplication.setAdditionalProfiles("dev");
        // 第二种：使用启动参数配置（不推荐），激活指定属性配置文件（可以激活多个！）
        // -Dspring.profiles.active=dev,test

        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.url"));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.drivername"));
    }

}
