package com.ypy.springbootinactiontwo.sixreadconfigfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * （1）更改application.properties默认配置文件名需要怎么做？
 *      需要在run config的启动参数(VM options)中设置：-Dspring.config.name=app
 *
 * （2）更改application.properties的存放路径需要怎么做？
 *      需要在run config的启动参数(VM options)中设置：-Dspring.config.location=classpath:dir/app.properties
 *      还可以指定多个配置文件，用,分割即可！(注意:file是文件路径)
 *      例如：-Dspring.config.location=classpath:dir/app.properties,file:/c:123.properties
 */
//@SpringBootApplication
public class App2 {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        // 知识点3: 使用修改启动类的方式，读取配置文件（不推荐使用）
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App2.class,args);
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("local.ip"));
        configurableApplicationContext.close();

    }

}
