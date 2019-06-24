package com.ypy.springinaction.third.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean级别的和Bean自身的生命周期方法
 */
public class User implements InitializingBean, DisposableBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("---------------第三步：【Bean级别】的生命周期方法：属性加载完之后：User afterPropertiesSet---------");
    }

    public void initMethod(){
        System.out.println("----------第四步：【Bean自身】的生命周期方法：自定义初始化：User self initMethod---------------");
    }

    public void destroy() throws Exception {
        System.out.println("------------第六步：【Bean级别】的生命周期方法：bean对象销毁：User destroy--------------");
    }

    public void destoryMethod(){
        System.out.println("------------第七步：【Bean自身】的生命周期方法：自定义销毁：User self destoryMethod---------------------");
    }


}
