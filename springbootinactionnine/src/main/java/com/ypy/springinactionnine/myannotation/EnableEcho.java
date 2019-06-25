package com.ypy.springinactionnine.myannotation;

import com.ypy.springinactionnine.beandefinationregister.EchoImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 第一步：定义注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EchoImportBeanDefinitionRegistrar.class)
public @interface EnableEcho {
    // 打印监听日志的包范围
    String[] packages();
}
