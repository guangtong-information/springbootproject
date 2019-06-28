package com.ypy.springbootstartjedis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 第一步：定义配置类，用于启动jedis的参数配置。默认从配置文件中读取属性值，注入到Bean。
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String host;

    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
