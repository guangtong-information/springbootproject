package com.ypy.springinactionnine.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;

/**
 * 第三步：定义Bean的后置处理器
 * Bean容器级别生命周期方法，也称为Bean的后置处理器，在Bean的初始化前后调用该方法
 */
public class EchoBeanPostProcessor implements BeanPostProcessor {

    // 需要打印监听日志的包范围
    private List<String> packages;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for(String pack:packages) {
            if (bean.getClass().getName().startsWith(pack)) {
                System.out.println("echo bean:" + bean.getClass().getName());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
