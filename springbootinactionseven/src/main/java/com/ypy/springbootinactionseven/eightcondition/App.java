package com.ypy.springbootinactionseven.eightcondition;

import com.ypy.springbootinactionseven.eightcondition.condition.encodinginterface.EncodingConvert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionseven.eightcondition.condition"})
public class App {

    public static void main(String[] args) {
        // 知识点1：自定义Condition接口实现类，实现Bean基于条件的装配
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);
        System.out.println(configurableApplicationContext.getBean(EncodingConvert.class));
        configurableApplicationContext.close();
    }
}
