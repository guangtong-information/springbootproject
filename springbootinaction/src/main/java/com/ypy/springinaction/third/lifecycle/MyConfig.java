package com.ypy.springinaction.third.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(name = "createUser", initMethod = "initMethod",destroyMethod = "destoryMethod")
    public User createUser(){
        return new User();
    }

}
