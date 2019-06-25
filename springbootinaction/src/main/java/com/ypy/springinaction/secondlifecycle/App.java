package com.ypy.springinaction.secondlifecycle;

import com.ypy.springinaction.secondlifecycle.appliaction.Bank;
import com.ypy.springinaction.secondlifecycle.appliaction.Book;
import com.ypy.springinaction.secondlifecycle.appliaction.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1、知识点1：ApplicationContext注入的三种方式
 * 2、知识点2：容器级别的生命周期方法
 */
public class App {

    public static void main(String[] args) {
        // 知识点1：ApplicationContext注入的三种方式
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.ypy.springinaction.secondlifecycle");
        // 方式一：使用@autowired，推荐的做法
        annotationConfigApplicationContext.getBean(User.class).show();

        // 方式二：实现ApplicationContextAware接口
        annotationConfigApplicationContext.getBean(Book.class).show();

        // 方式三：使用构造函数
        annotationConfigApplicationContext.getBean(Bank.class).show();

    }

}
