package com.ypy.springinaction.thirdlifecycleanddi.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 容器级别（顶级）的生命周期方法的学习
 * @author Ryan
 * @date 2019/6/24
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            System.out.println(beanName + "-----第二步：【容器级别】的生命周期方法-------postProcessBeforeInitialization------------" + bean.getClass());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            System.out.println(beanName + "-----第五步：【容器级别】的生命周期方法-------postProcessAfterInitialization------------" + bean.getClass());
        }
        return bean;
    }
}
