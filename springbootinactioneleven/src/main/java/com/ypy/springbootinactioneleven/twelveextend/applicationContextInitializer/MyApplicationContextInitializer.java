package com.ypy.springbootinactioneleven.twelveextend.applicationContextInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 第一步：定义接口的实现类
 * ApplicationContextInitializer是在spring容器执行refreshed之前的一个回调,提供我们操作的入口
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("bean count:" + configurableApplicationContext.getBeanDefinitionCount());
        for (String str:configurableApplicationContext.getBeanDefinitionNames()) {
            System.out.println(str);
        }

    }
}
