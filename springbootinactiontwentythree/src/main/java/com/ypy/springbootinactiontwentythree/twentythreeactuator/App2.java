package com.ypy.springbootinactiontwentythree.twentythreeactuator;

import com.ypy.springbootinactiontwentythree.twentythreeactuator.health.MyHealthIndicator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点2：自定义HealthCheck健康状态检查
 * 访问：http://127.0.0.1:8080/actuator/health
 *      如果你的应用里面有使用数据库，redis 、mq、MongoDB等，他都会执行健康检查！
 *      详见源码！spring-boot-actuate.jar 的具体实现类
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactiontwentythree.twentythreeactuator.health"})
public class App2 {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App2.class,args);
        System.out.println(configurableApplicationContext.getBean(MyHealthIndicator.class));
        System.out.println(configurableApplicationContext);
    }

}
