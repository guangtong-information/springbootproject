package com.ypy.springbootinactiontwo.sixreadconfigfile.propertysources;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 加载指定位置的配置文件
 */
@Configuration
//@propertysource("classpath:jdbc.properties")
//@propertysource("file:D:\gitlab\20180719-ypy-springboot\jdbc1.properties")
@PropertySources({@PropertySource("classpath:jdbc.properties"),@PropertySource("file:D:\\gitlab\\20180719-ypy-springboot\\jdbc1.properties")})
public class FileConfig {

}
