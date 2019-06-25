package com.ypy.springbootinactiontwo.sixreadconfigfile.propertysources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 知识点5：使用@ConfigurationProperties注解，自动加载环境变量的前缀
 * 注意：一定要生成getter和setter方法！！！
 * @author Ryan
 * @date 2019/4/2
 */
@Component
@ConfigurationProperties(prefix = "ds")
public class DatasourceProperties {

    // 自动注入字符串
    private String url;

    // 自动注入集合
    private List<String> hosts = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public void show(){
        System.out.println("ds.url = " + url);
        System.out.println("ds.host = " + hosts);
    }

}
