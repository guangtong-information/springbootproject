package com.ypy.springinactionnine.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 自动从配置文件中读取属性值，注入到Bean中
// 补充：或者使用environment.getProperty或者@Value(${"xxx"})的方式可以获取属性值
@ConfigurationProperties(prefix = "tomcat")
public class TomcatProperties {

    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "TomcatProperties{" +
                "port='" + port + '\'' +
                '}';
    }
}
