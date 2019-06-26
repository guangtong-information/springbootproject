package com.ypy.springbootinactionten.tenenableautoconfiguration;

import com.google.gson.Gson;
import com.ypy.tencorebean.Role;
import com.ypy.tencorebean.User;
import com.ypy.tencorebean.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 1、知识点1：EnableAutoConfiguration的使用和原理！
 *
 * 2、知识点2：可以在配置文件中，定义开关，是否启用EnableAutoConfiguration的自动加载功能
 *              spring.boot.enableautoconfiguration=false
 *              内部实现：可以参见AutoConfigurationImportSelector.isEnabled方法的实现！
 *
 * 3、知识点3：使用排除功能
 * （1）exclude将对应的对象，排除在装配的范围内。
 * （2）排除方式有2种，可以根据类或者根据名字！
 *
 * 4、知识点4：springboot默认会加载很多的外部化Bean到容器中【！重要！】
 * （1）spring-boot-autoconfigure.jar
 * （2）参见：META-INF/spring.factories；Auto Configure 里面定义了大量的外部化Bean装载到容器中的定义
 * （3）通过这种方式，springboot在接入第三方模块工具的时候，就会非常的方便
 *
 */
@EnableAutoConfiguration(exclude = UserConfiguration.class)
@ComponentScan(basePackages = {"com.ypy.springbootinactionten.tenenableautoconfiguration"})
//@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);
        /**
         * 知识点1:EnableAutoConfiguration的使用和原理！
         * （1）在classpath中搜索所有的/META-INF/spring.factories配置文件
         * （2）然后将其中的，org.springframework.boot.autoconfigure.EnableAutoConfiguration对应的配置类都加载到容器中！
         * （3）多个对象以逗号分割，例如：org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.ypy.springboot.springbootinaction.tencorebean.RunnableConfiguration,com.ypy.springboot.springbootinaction.tencorebean.UserConfiguration,com.ypy.springboot.springbootinaction.tencorebean.Role
         *
         * 内部实现的关键点：
         * （1）ImportSelector该接口的返回值都是类的全路径，所有的返回值都会导入到容器中
         * （2）AutoConfigurationImportSelector.selectImports
         * （3）AutoConfigurationImportSelector.getCandidateConfigurations
         * （4）具体的实现业务逻辑，可以看如上二个方法！
         *
         *
         */
//        System.out.println("runnable:" + configurableApplicationContext.getBean(Runnable.class));
//        System.out.println("role:" + configurableApplicationContext.getBean(Role.class));
//        System.out.println("user:" + configurableApplicationContext.getBean(User.class));

        // 知识点4：
        // spring-boot-autoconfigure.jar中的META-INF/spring.factories
        // 会加载GSon到容器中！
        System.out.println(configurableApplicationContext.getBean(Gson.class));

        configurableApplicationContext.close();
    }

}
