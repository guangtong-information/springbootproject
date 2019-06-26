package com.ypy.springbootinactioneleven.twelveextend;

import com.ypy.springbootinactioneleven.twelveextend.applicationContextInitializer.MyApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 所谓的扩展点，就是生命周期介绍
 * 知识点1：springboot扩展点分析（生命周期方法之一），ApplicationContextInitializer接口使用
 *          容器刷新refresh的时候，回调改接口
 *
 * 知识点2：springboot扩展点分析（生命周期方法之二），CommandLineRunner的学习
 * （1）在spring容器全部加载完最后一步，调用该接口
 * （2）实现步骤：
 *      第一：定义CommandLineRunner接口的实现类
 *      第二：注册接口，在实现类上，添加@Component注解，将实现类添加到容器
 * （3）可以定义多个CommandLineRunner接口实现类，可以通过@Order来定义执行的先后顺序
 *      Order（X）值越小，越先被执行
 *
 * 知识点3：springboot扩展点分析（生命周期方法之二），ApplicationRunner的学习
 * （1）在spring容器全部加载完最后一步前，回调该接口
 * （2）类似CommandLineRunner接口
 * （3）二者的区别在于抽象方法的入参有区别：CommandLineRunner，是原始参数、ApplicationRunner，是封装的参数
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactioneleven.twelveextend"})
public class App {

    public static void main(String[] args) {
        /**
         * 知识点1：springboot扩展点分析（生命周期方法之一），ApplicationContextInitializer接口使用
         * （1）ApplicationContextInitializer接口：是在spring容器执行refresh之前的一个回调，提供我们操作的入口
         * （2）实现步骤：
         *      第一步：定义接口的实现类
         *      第二步：注册接口，注册方式有如下三种：
         *          方式一：编码方式，springApplication.addInitializers(new MyApplicationContextInitializer());
         *          方式二：配置方式，在application.properties中定义,如果有多个接口的实现类，使用逗号分割
         *          context.initializer.classes=com.ypy.springbootinactioneleven.twelveextend.applicationContextInitializer.MyApplicationContextInitializer
         *          方式三：配置方式，在META-INF/spring.factories中定义,如果有多个接口的实现类，使用逗号分割
         *          rg.springframework.context.ApplicationContextInitializer=com.ypy.springbootinactioneleven.twelveextend.applicationContextInitializer.MyApplicationContextInitializer
         *
         */
        SpringApplication springApplication = new SpringApplication(App.class);
        // 第二步：注册接口 方式一
//        springApplication.addInitializers(new MyApplicationContextInitializer());
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run("123","456");
        configurableApplicationContext.close();

    }

}
