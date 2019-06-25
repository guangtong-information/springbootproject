package com.ypy.springbootinactiontwo.sixreadconfigfile.defaultconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 读取默认的配置文件
 *
 * 【重要】
 * 1、Springboot的默认配置文件名为：application.properties或者application.yml
 * 2、Springboot的默认配置文件存放路径：classpath或者classpath/config目录下
 *
 */
@Component
public class ReadDefaultConfigFile {

    // 方式一：使用Environment对象获取属性值
    @Autowired
    private Environment environment;

    // 方式二：使用注解+$符，获取属性值
    @Value("${port}")
    private String port;

    // 会自动进行类型转换
    @Value("${port}")
    private Integer port2;

    // 属性不存在的时候，可以通过指定默认值的方式，实现属性的定义
    @Value("${tomcat.port:8080}")
    private Integer tomcatPort;

    // 配置文件内的属性变量，可以相互引用
    @Value("${app.name}")
    private String appName;

    public void show(){
        System.out.println(environment.getProperty("port"));
        System.out.println(environment.getProperty("jdbc.ip"));

        System.out.println(port);
        System.out.println(port2);
        System.out.println(tomcatPort);
        System.out.println(appName);

    }

}
