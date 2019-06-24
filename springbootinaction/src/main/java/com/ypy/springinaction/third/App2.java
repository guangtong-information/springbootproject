package com.ypy.springinaction.third;

import com.ypy.springinaction.third.di.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 知识点2：
 */
public class App2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.ypy.springinaction.third.di");
        // jdk1.8的新写法：方法的引用
        annotationConfigApplicationContext.getBeansOfType(Person.class).values().forEach(System.out::println);
    }

}
