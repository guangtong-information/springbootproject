package com.ypy.springbootinactiontwo.sixreadconfigfile.propertysources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcConfig {

    @Value("${url}")
    private String url;

    @Value("${password}")
    private String password;

    public void show(){
        System.out.println(url);
        System.out.println(password);
    }

}
