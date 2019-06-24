package com.ypy.springinaction.first;

import com.ypy.springinaction.first.bean.Jeep;
import com.ypy.springinaction.first.bean.MyBean;
import com.ypy.springinaction.first.componentanddi.User;
import com.ypy.springinaction.first.componentanddi.UserDao;
import com.ypy.springinaction.first.componentanddi.UserServer;
import com.ypy.springinaction.first.config.MyConfig;
import com.ypy.springinaction.first.factorybean.RunnableFactoryBean2;
import com.ypy.springinaction.first.lifecycle.Animal;
import com.ypy.springinaction.first.lifecycle.Cat;
import com.ypy.springinaction.first.lifecycle.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 知识点1、使用配置类加载Bean
 * 知识点2、使用FactoryBean创建Bean
 * 知识点3、使用注解加载Bean
 * 知识点4、使用@Primary注解告诉容器优先加载那个Bean
 * 知识点5、Bean的生命周期（Bean自身、Bean级别）
 * 知识点6、Bean的依赖注入三种方式
 */
public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class, User.class, UserDao.class, UserServer.class);
        // 知识点1：使用配置类加载Bean
        // 根据类型获取对象
        System.out.println(annotationConfigApplicationContext.getBean(MyBean.class));
        // 根据名称获取对象，类似于spring配置文件中的id
        System.out.println(annotationConfigApplicationContext.getBean("myBean"));

        // 知识点2：获取FactoryBean创建的Bean对象（Jeep）
        // 根据类型获取
        System.out.println(annotationConfigApplicationContext.getBean(Jeep.class));
        // 根据名称获取
        System.out.println(annotationConfigApplicationContext.getBean("createRunnableFactoryBean2"));

        // 获取FactoryBean对象本身
        // 根据类型获取
        System.out.println(annotationConfigApplicationContext.getBean(RunnableFactoryBean2.class));
        // 根据名称获取
        System.out.println(annotationConfigApplicationContext.getBean("&createRunnableFactoryBean2"));

        // 知识点3：使用注解的方式加载Bean
        // 根据名称获取
        System.out.println(annotationConfigApplicationContext.getBean("myUser"));
        // 根据类型获取
        System.out.println(annotationConfigApplicationContext.getBean(UserDao.class));

        // 知识点4：多处定义Bean的时候，需要告诉容器优先选择加载谁，否则启动会抛错
        System.out.println(annotationConfigApplicationContext.getBean(User.class));

        // 知识点5：Bean的生命周期演示
        System.out.println(annotationConfigApplicationContext.getBean(Cat.class));
        System.out.println(annotationConfigApplicationContext.getBean(Dog.class));
        System.out.println(annotationConfigApplicationContext.getBean(Animal.class));

        // 知识点6：Bean的依赖注入的三种方式
        System.out.println(annotationConfigApplicationContext.getBean(UserServer.class));

        annotationConfigApplicationContext.close();
    }


}
