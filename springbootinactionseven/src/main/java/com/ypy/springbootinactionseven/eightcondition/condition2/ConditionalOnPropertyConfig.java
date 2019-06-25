package com.ypy.springbootinactionseven.eightcondition.condition2;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@SpringBootConfiguration
public class ConditionalOnPropertyConfig {

    /**
     * @ConditionalOnProperty配置存在或者等于某个值的时候，装配Bean
     *
     * 说明：
     * （1）从【配置文件】，中获取runnable.enable的属性值，
     * （2）havingValue:等于true的时候，装配Bean，否则不装配。
     * （3）matchIfMissing:不存在的时候，返回true，所以也装配
     */
    @Bean
    @ConditionalOnProperty(name = "runnable.enable",havingValue = "true",matchIfMissing = true)
    public Runnable createRunnable(){
        return ()->{};
    }

}
