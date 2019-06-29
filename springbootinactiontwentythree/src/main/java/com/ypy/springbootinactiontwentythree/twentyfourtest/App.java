package com.ypy.springbootinactiontwentythree.twentyfourtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactiontwentythree.twentyfourtest"})
public class App {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(App.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
//        System.out.println(configurableApplicationContext.getBean(UserDao.class).addUser("test"));
    }

}
