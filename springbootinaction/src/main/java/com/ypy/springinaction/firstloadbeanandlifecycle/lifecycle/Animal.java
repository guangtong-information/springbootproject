package com.ypy.springinaction.firstloadbeanandlifecycle.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Animal {

    @PostConstruct
    public void init(){
        System.out.println("--------PostConstruct--------");
    }

    @PreDestroy
    public void destory(){
        System.out.println("---------PreDestroy-------");
    }

}
