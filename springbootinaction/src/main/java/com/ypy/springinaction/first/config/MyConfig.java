package com.ypy.springinaction.first.config;

import com.ypy.springinaction.first.bean.MyBean;
import com.ypy.springinaction.first.componentanddi.User;
import com.ypy.springinaction.first.factorybean.RunnableFactoryBean2;
import com.ypy.springinaction.first.lifecycle.Animal;
import com.ypy.springinaction.first.lifecycle.Cat;
import com.ypy.springinaction.first.lifecycle.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * 配置类，用于配置Bean
 */
@Configuration
public class MyConfig {

    @Bean("myBean") // 不指定name，默认为方法名
    @Scope("singleton")// 默认为singleton单例模式，prototype每次都创建新的对象
    public MyBean createMyBean(){
        return new MyBean();
    }

    @Bean
    public RunnableFactoryBean2 createRunnableFactoryBean2(){
        return new RunnableFactoryBean2();
    }

    @Bean
    @Primary
    public User createUser(){
        return new User();
    }

    @Bean
    public Cat createCat(){
        return new Cat();
    }

    @Bean(initMethod = "initDog",destroyMethod = "destroyDog")
    public Dog createDog(){
        return new Dog();
    }

    @Bean
    public Animal createAnimal(){
        return new Animal();
    }
}
