package com.ypy.springinaction.firstloadbeanandlifecycle;

import com.ypy.springinaction.firstloadbeanandlifecycle.bean.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

    public static void main(String[] args) {

        // 知识点7：通过扫描的方式实现容器加载Bean -- 推荐做法
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.ypy.springinaction.firstloadbeanandlifecycle");
        System.out.println(annotationConfigApplicationContext.getBean("myBean"));
        System.out.println(annotationConfigApplicationContext.getBean(MyBean.class));

    }

}
