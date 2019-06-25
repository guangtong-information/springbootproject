package com.ypy.springinactionnine.myannotation;

import com.ypy.springinactionnine.beandefinationregister.MyImportBeanDefinationRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解：
 * 改注解使用Import+ImportBeanDefinitionRegistrar，实现类似于EnableAsync或者EnableConfigurationProperties的功能！
 * 和EnableLog的实现方式没有本质区别！！！
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportBeanDefinationRegister.class)
public @interface EnableLog2 {
    String name();
}
