package com.ypy.tencorebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan
 * @date 2019/6/26
 */
@Configuration
public class RunnableConfiguration {

    @Bean
    public Runnable createRunnable(){
        return ()->{ };
        /*return new Runnable(){
            @Override
            public void run() {

            }
        };*/
    }

}
