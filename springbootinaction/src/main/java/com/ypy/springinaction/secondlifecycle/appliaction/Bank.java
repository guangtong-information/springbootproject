package com.ypy.springinaction.secondlifecycle.appliaction;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Bank {

    private ApplicationContext applicationContext;

    /* 不能创建无参的构造函数，否则容器默认只会调用无参的构造函数创建对象
    public Bank(){

    }*/

    /**
     * spring4.3新特性，会自动从容器中获取相关对象，传入到构造函数，用于对象的创建
     * @param applicationContext
     */
    public Bank(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public void show(){
        System.out.println("Bank:" + applicationContext.getClass());
    }
}

