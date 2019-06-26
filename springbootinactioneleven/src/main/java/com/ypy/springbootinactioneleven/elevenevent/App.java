package com.ypy.springbootinactioneleven.elevenevent;

import com.ypy.springbootinactioneleven.elevenevent.event.MyAppliactionEvent;
import com.ypy.springbootinactioneleven.elevenevent.event.MyAppliactionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点1：定义一个最简单的事件监听
 *
 * 知识点2：第三种配置监听器的实现原理
 * 具体实现可以参见DelegatingApplicationListener.onApplicationEvent的实现
 *
 * 知识点3：第四种使用注解的方式的实现原理
 * 具体实现可以参见EventListenerMethodProcessor.processBean的实现
 *
 * 知识点4：spring和springboot自带的事件
 * （1）详情请见：spring-context.jar 里面的org.springframework.context.event包下
 * （2）详情请见：spring-boot.jar里面的org.springframework.boot.context.event包下
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactioneleven.elevenevent"})
public class App {

    public static void main(String[] args) {

        /**
         * 知识点1：定义一个最简单的事件监听
         * 设计初衷是为了系统业务逻辑之间的解耦，提高可扩展性和可维护性
         * 事件监听四步曲：
         * 第一步：定义事件MyApplicationEvent，继承ApplicationEvent
         * 第二步：定义事件监听器MyApplicationListener，实现ApplicationLstener
         * 第三步：配置监听，将事件监听器添加到容器
         *          方式一：编码方式，SpringApplication.addListener(new MyApplicationListener())，在容器启动的时候，将监听器添加到容器
         *          方式二：编码方式，将监听器纳入到容器中管理，在监听器上增加@Component注解
         *          方式三：配置方式，在application.properties中配置事件监听
         *          方式四：编码方式，使用@EventListener注解
         *          方式五：配置方式，在META-INF/spring.factories中配置事件监听
         * 第四步：发布事件，测试验证
         */
        SpringApplication springApplication = new SpringApplication(App.class);
        // 第三步：配置监听，方式一，编码方式
//        springApplication.addListeners(new MyAppliactionListener());
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        // 第四步：发布事件，测试验证
        configurableApplicationContext.publishEvent(new MyAppliactionEvent(new Object()));

        configurableApplicationContext.close();
    }

}
