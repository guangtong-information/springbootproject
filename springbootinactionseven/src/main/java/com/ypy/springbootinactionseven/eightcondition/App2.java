package com.ypy.springbootinactionseven.eightcondition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionseven.eightcondition.condition2"})
public class App2 {

    public static void main(String[] args) {
        // 知识点2：使用系统自带的Condition，实现Bean按照条件的装配
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App2.class,args);
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }

}
