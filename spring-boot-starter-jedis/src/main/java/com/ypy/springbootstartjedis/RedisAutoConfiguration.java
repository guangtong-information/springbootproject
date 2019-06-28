package com.ypy.springbootstartjedis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * 第二步：自动注入Jedis对象
 * @Configuration：当前是一个配置类
 * @ConditionalOnClass：容器中存在Jedis的Class的时候，才启动配置类
 * @EnableConfigurationProperties：开启自动装配配置文件属性值到Bean，并加载到容器中！
 */
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties){
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }

}
