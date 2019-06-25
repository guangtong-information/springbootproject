package com.ypy.springinactionnine;

import com.ypy.springinactionnine.importannotation.Role;
import com.ypy.springinactionnine.importannotation.User;
import com.ypy.springinactionnine.importselector.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 知识点4：使用@Import和ImportSelector实现类的学习
 * （1）导入Bean到容器
 * （2）导入一个配置类到容器
 */
@Import(MyImportSelector.class)
public class App4 {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App4.class,args);
        System.out.println(configurableApplicationContext.getBean(Role.class));
        System.out.println(configurableApplicationContext.getBean(User.class));
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }
}
