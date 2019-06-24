package com.ypy.springinaction.first.lifecycle;

public class Dog {

    // 初始化所有属性以后，调用自定义初始化方法
    public void initDog(){
        System.out.println("-----------initBySelf-------------");
    }

    // 容器销毁（销毁Bean）的时候，调用自定义销毁方法
    public void destroyDog(){
        System.out.println("-----------destroyBySelf----------");
    }

}
