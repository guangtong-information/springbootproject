package com.ypy.springbootinactionfifteen.sixteenweb2.servlet;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

//@Configuration
@SpringBootConfiguration
public class ServletConfig {

    // 装配一个Servlet对象到容器中
    @Bean
    public ServletRegistrationBean createBookServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new BookServlet(),"/book.do");
        return servletRegistrationBean;
    }

    // 装配一个Filter对象
    @Bean
    public FilterRegistrationBean createFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter2());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/book.do"));
        return filterRegistrationBean;
    }

    // 装配一个Listener对象
    @Bean
    public ServletListenerRegistrationBean createServletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new ServletContextListener2());
        return servletListenerRegistrationBean;
    }

}
