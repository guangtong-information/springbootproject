package com.ypy.springinaction.first;

import com.ypy.springinaction.first.bean.MyBean;
import com.ypy.springinaction.first.componentanddi.UserServer;
import com.ypy.springinaction.first.componentscan.AnnotationComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {

    public static void main(String[] args) {

        // 知识点8：容器启动的时候，传入扫描类，还可以指定哪些类不加载的容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnotationComponentScan.class);
        System.out.println(annotationConfigApplicationContext.getBean(UserServer.class));
    }

}
