package com.ypy.springbootinactionfifteen.eighteentomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 知识点1：使用配置的方式，设置tomcat相关参数
 * （1）在application.properties中定义
 * （2）设置如下内容：
 * #tomcat的设置
 * #开启日志访问
 * server.tomcat.accesslog.enabled=true
 * #日志保存路径
 * server.tomcat.accesslog.directory=c:/tmp/tomcat.log
 * （3）更多内容参见：org.springframework.boot.autoconfigure.web.ServerProperties
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionfifteen.eighteentomcat"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
