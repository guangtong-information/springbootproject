package com.ypy.springinaction.first.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean的生命周期演示
 */
public class Cat implements InitializingBean, DisposableBean {

    // 初始化所有属性以后，调用该方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("--------afterPropertiesSet---------");
    }

    // 容器销毁（销毁Bean）的时候，调用该方法
    public void destroy() throws Exception {
        System.out.println("----------destroy-----------");
    }

}
