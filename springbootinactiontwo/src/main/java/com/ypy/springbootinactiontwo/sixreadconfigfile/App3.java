package com.ypy.springbootinactiontwo.sixreadconfigfile;

import com.ypy.springbootinactiontwo.sixreadconfigfile.propertysources.DatasourceProperties;
import com.ypy.springbootinactiontwo.sixreadconfigfile.propertysources.JdbcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactiontwo.sixreadconfigfile.propertysources"})
public class App3 {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App3.class,args);
        // 知识点4：使用@PropertySources注解，读取指定路径下的配置文件
        configurableApplicationContext.getBean(JdbcConfig.class).show();

        // 知识点5：使用@ConfigurationProperties注解，自动加载环境变量的前缀
        configurableApplicationContext.getBean(DatasourceProperties.class).show();
        configurableApplicationContext.close();

    }

}
