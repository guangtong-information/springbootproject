package com.ypy.springinactionnine.myannotation;

import com.ypy.springinactionnine.importselector.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解:
 * 该注解使用@Import(MyImportSelector.class),实现类似于@EnableAsyn或者@EnableConfigurationProperties的功能
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportSelector.class)
public @interface EnableLog {
    String name();
}
