package com.ypy.springinactionnine.importannotation;

import org.springframework.context.annotation.Bean;

public class MyConfigration {

    @Bean
    public Runnable createRunnable(){
        return ()->{};
    }

    @Bean
    public Runnable createRunnable2(){
        return ()->{};
    }
}
