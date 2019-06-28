package com.ypy.springbootstartjedis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 第三步：为了让容器自动加载第三方jar的Bean，需要使用如下二种方式：
 * 方式一：使用@Import注解，导入需要装配的类
 * 方式二：在META-INF/spring.factories文件中配置，配置需要装配的类（推荐使用，简单无依赖）
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisAutoConfiguration.class)
public @interface EnableRedis {

}
