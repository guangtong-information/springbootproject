package com.ypy.springbootinactionfifteen.sixteenweb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 知识点3：方式二：使用配置类来装配Servlet、Filter、Listener，不需要在写@WebServlet、@WebFilter、@WebListener
 *（1）基于特殊的Bean：ServletRegistrationBean 来装配Servlet
 *（2）基于特殊的Bean：FilterRegistrationBean 来装配Filter
 *（3）基于特殊的Bean：ServletListenerRegistrationBean 来装配Listener
 *（4）这样方式是依赖于Springboot提供的相关注解，区别方式一依赖的是Servlet3.0！推荐使用方式一，更加方便一点。
 *
 * 测试地址：
 * http://127.0.0.1:8080/book.do
 *
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionfifteen.sixteenweb2.servlet"})
public class App3 {
    public static void main(String[] args) {
        SpringApplication.run(App3.class,args);
    }
}
