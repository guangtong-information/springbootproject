package com.ypy.springbootinactionseven.eightcondition.condition2;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ConditionalOnMisingBeanConfig {

    /**
     * @ConditionalOnMissingBean,根据容器中是否存在某个Bean进行条件装配！
     *
     * （1）不存在的时候，就装配
     * （2）存在的时候，就不装配
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name ="user")
    public Runnable createBeanRunnable(){
        return ()->{};
    }

}
