package com.ypy.springbootinactiontwo.sixreadconfigfile;

import com.ypy.springbootinactiontwo.sixreadconfigfile.defaultconfig.ReadDefaultConfigFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactiontwo.sixreadconfigfile.defaultconfig"})
public class App {

    public static void main(String[] args) {

        // 知识点2：读取默认的配置文件
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);
        configurableApplicationContext.getBean(ReadDefaultConfigFile.class).show();
        configurableApplicationContext.close();

    }

}
