package com.ypy.springbootinactioneleven.elevenevent.event;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 第三步：配置监听，方式四，编码方式，使用@EventListener注解
 */
//@Component
public class MyEventHandler {

    /**
     * 方法的参数可以任意
     * 注意：
     * （1）如果参数是Object，可以监听到含MyApplicationEvent在内的很多事件,例如容器的启动、关闭、刷新等
     * （2）如果参数是MyApplicationEvent，那么只能监听到MyApplicationEvent的事件
     * @param myApplicationEvent
     */
    @EventListener
    public void event(Object myApplicationEvent){
        System.out.println("接收到事件：" + myApplicationEvent.getClass());
    }

    @EventListener
    public void event(ApplicationStartedEvent applicationStartedEvent){
        System.out.println("-----监听到springboot应用启动的事件-----" + applicationStartedEvent.getClass());
    }

}
