package com.ypy.springinaction.first.componentscan;

import com.ypy.springinaction.first.componentanddi.UserServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 定义扫描的范围，可以在excludeFilters中指定排除那些包不扫描
 */
//@ComponentScan(basePackages = "com.ypy.springinaction.first",excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE ,classes= UserServer.class))
@ComponentScan(basePackages = "com.ypy.springinaction.first")
@Configuration
public class AnnotationComponentScan {
}
