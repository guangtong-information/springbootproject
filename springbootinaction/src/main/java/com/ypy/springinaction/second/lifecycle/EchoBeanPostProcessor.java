package com.ypy.springinaction.second.lifecycle;

import com.ypy.springinaction.second.appliaction.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 知识点2：容器级别的生命周期方法
 * Bean创建的时候，都会调用该类
 *
 * 作用：
 * 1、类似于切面，在Bean创建的时候，可以做想要的扩展，例如打印日志，回调等
 * 2、每个Bean创建的时候，都会调用改容器级别的生命周期方法！
 */
@Component
public class EchoBeanPostProcessor implements BeanPostProcessor {

    // 对象初始化（构造函数+自定义初始化方法）之前
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            System.out.println("------------监控日志输出------------");
        }
        System.out.println(beanName +  "-----------postProcessBeforeInitialization-----------");
        return bean;
    }

    // 对象初始化(构造函数+自定义初始化方法)完成以后
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName +  "-----------postProcessAfterInitialization-----------");
        return bean;
    }
}
