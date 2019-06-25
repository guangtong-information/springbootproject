package com.ypy.springbootinactionseven.sevenreadconfigfile.environmentpostprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 知识点一：【统一配置中心的原型】
 * 统一的动态的加载配置文件：Springboot需要经过如下二步：
 * 第一步：实现EnvironmentPostProcessor接口的接口
 * 第二步：配置META-INF/spring.factories
 *
 * 注意：
 * 1、配置文件的中心化，实现统一配置文件
 * 2、有了这个类，我们就可以读取任何配置文件，我们可以利用HttpClient读取远程配置。
 * 3、其他应用启动的时候，读取该统一配置
 * 4、不需要在每个应用中添加配置文件，实现配置文件的统一化管理！！！
 */
public class ConfigurationCenter implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            InputStream inputStream = new FileInputStream("D:/gitlab/20180719-ypy-springboot/jdbc1.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("my",properties);
            environment.getPropertySources().addLast(propertiesPropertySource);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
