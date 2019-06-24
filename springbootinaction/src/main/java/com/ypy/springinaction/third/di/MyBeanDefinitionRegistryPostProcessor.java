package com.ypy.springinaction.third.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * MyBeanDefinitionRegistryPostProcessor 可以拿到BeanDefinitionRegistry对象，从而可以实现动态注入Bean对象。
 *
 * 类似于反射！Spring容器内部就是通过这些方法的封装，实现Bean的动态注入！
 *
 * 比BeanFactoryPostProcessor高级很多。BeanFactoryPostProcessor只会在容器创建完成以后，而且只会触发一次！
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        for(int i=0;i<10;i++){
            // 获取Person对象，类似反射（动态注入Bean）
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Person.class);
            // 注入属性值，类似于反射
            beanDefinitionBuilder.addPropertyValue("name","admin"+i);
            beanDefinitionRegistry.registerBeanDefinition("person" + i,beanDefinitionBuilder.getBeanDefinition());
        }

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
