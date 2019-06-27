package com.ypy.springbootinactionfifteen.sixteenweb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 知识点1：访问静态资源
 * （1）src/main/webapp目录下就可以直接访问
 *      http://127.0.0.1:8080/img/springcloud.jpg
 *
 * （2）默认这四个路径："classpath:/META-INF/resources/", "classpath:/resources/","classpath:/static/", "classpath:/public/"
 *      http://127.0.0.1:8080/login.html
 *
 * （3）详情可以查看：spring-boot-autoconfigure.jar ResourceProperties.java类定义静态资源
 * （4）（不推荐修改）可以在配置文件中修改spring.resources静态资源路径：spring.resources.static-locations=classpath:/html
 *      http://127.0.0.1:8080/reg.html
 *
 *  注意：在springboot 在idea多模块下 子模块的web项目用内置tomcat启动访问静态报404
 *  解决方案：https://blog.csdn.net/qq_34657993/article/details/79070084
 *  或者查看笔记：
 * “springboot 在idea多模块下 子模块的web项目用内置tomcat启动访问jsp报404 - qq_34657993的博客 - CSDN博客”
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
