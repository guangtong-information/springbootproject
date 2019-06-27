package com.ypy.springbootinactionfifteen.seventeenweb3.handlerinterceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 第二步：装配拦截器，托管到容器
 */
@SpringBootConfiguration
public class WebConfiguration extends WebMvcConfigurerAdapter{
    // 装配Springboot拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor());
    }
}
