package com.ypy.springinaction.third;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1、知识点1：Bean生命周期详细分析
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.ypy.springinaction.third.lifecycle");
        annotationConfigApplicationContext.getBean("createUser");
        annotationConfigApplicationContext.close();
    }

}
