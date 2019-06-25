package com.ypy.springbootinactionseven.eightcondition.condition2;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@SpringBootConfiguration
public class ConditionalOnClassConfig {

    // @ConditionalOnClass,根据容器中是否存某个类的时候，装配Bean，否则不装配！
    @Bean
    @ConditionalOnClass(name = "com.google.gson.Gson")
    public Runnable createGsonRunnable(){
        return ()->{};
    }

}
