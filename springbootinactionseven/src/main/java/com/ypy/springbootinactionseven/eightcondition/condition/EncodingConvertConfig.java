package com.ypy.springbootinactionseven.eightcondition.condition;

import com.ypy.springbootinactionseven.eightcondition.condition.encodinginterface.EncodingConvert;
import com.ypy.springbootinactionseven.eightcondition.condition.encodinginterface.GBKEncodingConvert;
import com.ypy.springbootinactionseven.eightcondition.condition.encodinginterface.UTF8EncodingConvert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * （1）使用@Condition注解实现Bean基于条件的装配
 * 如果返回true，那么装配
 * 如果返回false，那么不装配
 *
 * （2）@Condition也可以使用在类上，那么将影响整个类的Bean的装配
 *
 */
@Configuration
public class EncodingConvertConfig {

    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConvert createUTF8EncodingConvert(){
        return new UTF8EncodingConvert();
    }

    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvert createGBKEncodingConvert(){
        return new GBKEncodingConvert();
    }

}
