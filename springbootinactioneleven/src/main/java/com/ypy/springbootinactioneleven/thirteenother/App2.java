package com.ypy.springbootinactioneleven.thirteenother;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 知识点4：配置项添加默认值的三种方式，第三方方式优先级最高
 * 注意：如果配置文件中有配置项，优先级最高！
 */
@SpringBootApplication
public class App2 {

    // 方式一：配置项添加默认的属性值
    @Value("${server.host:127.0.0.1}")
    private String serverHost;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App2.class);

        // 方式三：设置配置项的默认值，优先取改默认值！
        Map<String,Object> defaultProperties = new HashMap<>();
        defaultProperties.put("server.host","192.168.0.1");
        springApplication.setDefaultProperties(defaultProperties);

        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);

        // 方式二：配置项给默认值
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("server.host","localhost"));
        System.out.println(configurableApplicationContext.getBean(App2.class).serverHost);

        configurableApplicationContext.close();
    }

}
