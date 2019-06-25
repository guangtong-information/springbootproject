package com.ypy.springinactionnine;

import com.ypy.springinactionnine.importannotation.Role;
import com.ypy.springinactionnine.importannotation.User;
import com.ypy.springinactionnine.myannotation.EnableLog;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点5：
 * （1）自定义注解，比知识点4更加深入一步
 * （2）在定义注解上使用@Import(MyImportSelector.class)，实现Bean导入到容器
 * （3）在MyImportSelector实现类中，可以拿到自定义注解的值详细信息，从而实现条件的判断
 * （4）该实例时在进一步模拟：@EnableAsync和@EnableConfigurationProperties的实现原理！
 */
@EnableLog(name = "my springboot")
public class App5 {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App5.class,args);
        System.out.println(configurableApplicationContext.getBean(User.class));
        System.out.println(configurableApplicationContext.getBean(Role.class));
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }

}
