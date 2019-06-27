package com.ypy.springbootinactionfifteen.seventeenweb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * 知识点3：Springboot的全局异常处理类
 * （1）局部的异常处理类
 *      在某一个类中定义方法，使用@ExceptionHandler(value = Exception.class)
 *      只能处理当前类中发生的异常
 *
 * （2）全局的异常处理类
 *      定义一个类GlobalException类，使用@ControllerAdvice注解
 *      定义一个方法，使用@ExceptionHandler(value = Exception.class)，表示可以处理所有的异常
 *
 * （3）注意：局部和全局异常都满足的时候，优先选择局部异常！
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class ,scanBasePackages = {"com.ypy.springbootinactionfifteen.seventeenweb3.globalexception"})
public class App3  {

    public static void main(String[] args) {
        SpringApplication.run(App3.class,args);
    }

}
