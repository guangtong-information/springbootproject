package com.ypy.tencorebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan
 * @date 2019/6/26
 */
@Configuration
public class UserConfiguration {

    @Bean
    public User createUser(){
        return new User();
    }

}
