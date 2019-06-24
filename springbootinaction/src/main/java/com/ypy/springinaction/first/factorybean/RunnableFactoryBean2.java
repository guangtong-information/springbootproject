package com.ypy.springinaction.first.factorybean;

import com.ypy.springinaction.first.bean.Jeep;
import org.springframework.beans.factory.FactoryBean;

/**
 * 使用FactoryBean来创建Bean
 */
public class RunnableFactoryBean2 implements FactoryBean<Jeep> {

    public Jeep getObject() throws Exception {
        return new Jeep();
    }

    public Class<?> getObjectType() {
        return Jeep.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
