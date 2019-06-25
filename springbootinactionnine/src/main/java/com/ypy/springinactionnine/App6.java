package com.ypy.springinactionnine;

import com.ypy.springinactionnine.importannotation.Role;
import com.ypy.springinactionnine.importannotation.User;
import com.ypy.springinactionnine.myannotation.EnableLog2;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点6：
 * （1）自定义注解（比知识点4更进一步）（类似于知识点5）
 * （2）在自定义注解上使用@Import(MyImportBeanDefinationRegister.class)
 * （3）在MyImportBeanDefinationRegister上可以拿到注解的值信息，从而实现条件判断
 * （4）进一步模拟@EnableConfigurationProperties、@EnableAsync的实现原理！！！
 *
 */
@EnableLog2(name = "my springboot2")
public class App6 {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App6.class,args);
        System.out.println(configurableApplicationContext.getBean(User.class));
        System.out.println(configurableApplicationContext.getBean(Role.class));
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }

}
