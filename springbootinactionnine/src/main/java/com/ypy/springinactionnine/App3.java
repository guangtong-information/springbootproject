package com.ypy.springinactionnine;

import com.ypy.springinactionnine.importannotation.MyConfiguration;
import com.ypy.springinactionnine.importannotation.Role;
import com.ypy.springinactionnine.importannotation.User;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 知识点3：
 * （1）使用@Import注解，将Bean添加到容器
 * （2）使用@Import注解，将配置类添加到容器，同时将配置类中所定义的Bean全部装配到容器
 */
@Import({Role.class, User.class, MyConfiguration.class})
public class App3 {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App3.class,args);
        System.out.println(configurableApplicationContext.getBean(Role.class));
        System.out.println(configurableApplicationContext.getBean(User.class));
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }
}
