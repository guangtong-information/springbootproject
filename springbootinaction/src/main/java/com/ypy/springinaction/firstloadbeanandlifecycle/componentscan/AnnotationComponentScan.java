package com.ypy.springinaction.firstloadbeanandlifecycle.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 定义扫描的范围，可以在excludeFilters中指定排除那些包不扫描
 */
//@ComponentScan(basePackages = "com.ypy.springinaction.firstloadbeanandlifecycle",excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE ,classes= UserServer.class))
@ComponentScan(basePackages = "com.ypy.springinaction.firstloadbeanandlifecycle")
@Configuration
public class AnnotationComponentScan {
}
