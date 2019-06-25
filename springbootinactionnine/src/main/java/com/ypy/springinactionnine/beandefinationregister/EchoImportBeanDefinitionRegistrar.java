package com.ypy.springinactionnine.beandefinationregister;

import com.ypy.springinactionnine.demo.EchoBeanPostProcessor;
import com.ypy.springinactionnine.myannotation.EnableEcho;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 第二步：EchoImportBeanDefinitionRegistrar接口实现类
 * 将Bean的后置处理器EchoBeanPostProcessor导入到容器
 */
public class EchoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //获取注解中传递过来的属性值，指定的packge包名
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(EnableEcho.class.getName());
        String[] packagesAttributes = (String[])attributes.get("packages");
        List<String> packages = Arrays.asList(packagesAttributes);
        System.out.println("--------------packages:" + packages);

        // 向容器中，注入Bean的后置处理器
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);
        bdb.addPropertyValue("packages",packages);
        BeanDefinition beanDefinitionUser = bdb.getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition(EchoBeanPostProcessor.class.getName(),beanDefinitionUser);
    }
}
