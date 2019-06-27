package com.ypy.springbootinactionfifteen.sixteenweb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 知识点2：方式一：在Springboot中使用servlet、filter、listener
 *（1）使用@ServletComponentScan注解，将servelt加载到容器
 *（2）使用@WebServlet("/user.do")//servlet3.0的写法，基于注解，创建一个servlet
 *（3）使用@WebFilter("/user.do")，创建一个过滤器
 *（4）使用@WebListener，创建一个监听器
 *
 * 访问地址：http://127.0.0.1:8080/user.do
 *
 */
@ServletComponentScan(basePackages = {"com.ypy.springbootinactionfifteen.sixteenweb2.servlet3"})
@SpringBootApplication
public class App2 {

    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }

}
