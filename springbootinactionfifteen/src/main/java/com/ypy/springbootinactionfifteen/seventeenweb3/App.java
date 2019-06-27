package com.ypy.springbootinactionfifteen.seventeenweb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 知识点1：Springboot的拦截器（类似于Servlet中的Filter）
 * 第一步：定义拦截器，实现HandlerInterceptor接口的三个方法，分布在Controller被执行以及页面被渲染前后，调用
 * 第二步：注册拦截器，继承WebMvcConfigurerAdapter，重写addInterceptors方法，注册拦截器
 * 第三步：定义测试类
 * 第四步：测试验证
 *
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionfifteen.seventeenweb3.handlerinterceptor"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
