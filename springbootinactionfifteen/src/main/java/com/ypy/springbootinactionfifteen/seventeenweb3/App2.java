package com.ypy.springbootinactionfifteen.seventeenweb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * 知识点2：自定义异常处理，不使用Springboot自带的异常处理类ErrorMvcAutoConfiguration
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class,scanBasePackages = {"com.ypy.springbootinactionfifteen.seventeenweb3.exception"})
public class App2 {

    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }

}
