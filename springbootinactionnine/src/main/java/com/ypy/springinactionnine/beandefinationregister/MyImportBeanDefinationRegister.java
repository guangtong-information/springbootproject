package com.ypy.springinactionnine.beandefinationregister;

import com.ypy.springinactionnine.importannotation.MyConfiguration;
import com.ypy.springinactionnine.importannotation.Role;
import com.ypy.springinactionnine.importannotation.User;
import com.ypy.springinactionnine.myannotation.EnableLog2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 * ImportBeanDefinationRegister实现类，也可以动态导入Bean到容器
 * 类似于ImportSelector的实现类
 * 区别在于：
 * （1）ImportSelector的实现类的返回值，会被容器托管起来
 * （2）ImportBeanDefinationRegister的实现类，是自己将Bean主动导入到容器
 * （3）二者最终的效果都是一样的，将Bean或者配置类中定义的Bean，导入到容器
 *
 */
public class MyImportBeanDefinationRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        /**
         * 这里可以获取注解的详细信息！
         * 然后根据注解的详细信息，返回需要被spring容器管理的Bean！
         */
        System.out.println(annotationMetadata.getAllAnnotationAttributes(EnableLog2.class.getName()));

        BeanDefinitionBuilder bdbUser = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        BeanDefinitionBuilder bdbRole = BeanDefinitionBuilder.rootBeanDefinition(Role.class);
        BeanDefinitionBuilder bdbMyConfiguration = BeanDefinitionBuilder.rootBeanDefinition(MyConfiguration.class);

        BeanDefinition beanDefinitionUser = bdbUser.getBeanDefinition();
        BeanDefinition beanDefinitionRole = bdbRole.getBeanDefinition();
        BeanDefinition beanDefinitionMyConfiguration = bdbMyConfiguration.getBeanDefinition();

        /**
         * BeanDefinitionRegistry可以向容器中注入Bean
         */
        beanDefinitionRegistry.registerBeanDefinition("user",beanDefinitionUser);
        beanDefinitionRegistry.registerBeanDefinition("role",beanDefinitionRole);
        beanDefinitionRegistry.registerBeanDefinition("myConfiguration",beanDefinitionMyConfiguration);
    }
}
