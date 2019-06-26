package com.ypy.springbootinactioneleven.elevenevent.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 第二步：定义事件监听
 */
// 第三步：配置监听器，方式二，编码方式
//@Component
public class MyAppliactionListener implements ApplicationListener<MyAppliactionEvent> {
    @Override
    public void onApplicationEvent(MyAppliactionEvent myAppliactionEvent) {
        System.out.println("-------接收到事件：------" + myAppliactionEvent.getClass());
    }
}
