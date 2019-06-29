package com.ypy.springbootinactiontwentythree.twentyfourtest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 知识点3：仅在测试环境装配的Bean
 * @author Ryan
 * @date 2019/4/17
 */
@TestConfiguration
public class TestBeanConfiguration {

    @Bean
    public Runnable createRunnable(){
        return () -> {};
    }

}
