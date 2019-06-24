package com.ypy.springinaction.third.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 容器级别（顶级）的生命周期方法的学习
 * 注意：
 * 1、只会初始化一次
 * 2、在容器启动的时候被调用
 * 3、同时是在所有的Bean被创建之前调用！
 * @author Ryan
 * @date 2019/6/24
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("========第一步：【容器级别】的生命周期方法：只会调用一次==========" + configurableListableBeanFactory.getBeanDefinitionCount());
    }
}
