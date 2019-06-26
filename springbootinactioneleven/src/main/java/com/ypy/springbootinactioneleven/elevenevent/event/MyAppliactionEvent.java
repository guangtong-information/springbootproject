package com.ypy.springbootinactioneleven.elevenevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * 第一步：定义事件
 */
public class MyAppliactionEvent extends ApplicationEvent {

    public MyAppliactionEvent(Object source) {
        super(source);
        System.out.println("事件发生");
    }
}
