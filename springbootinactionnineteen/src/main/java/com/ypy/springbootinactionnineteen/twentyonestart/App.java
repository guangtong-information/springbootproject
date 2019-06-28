package com.ypy.springbootinactionnineteen.twentyonestart;

import com.ypy.springbootstartjedis.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * 知识点：自定义springboot的start启动类
 * （1）第一步：实现自定义的spring-boot-starter-jedis jar项目，该项目可以直接加载Jedis对象到容器
 *         --第一步：定义配置类，用于启用jedis的参数配置。默认从配置文件中读取属性值，注入到Bean中!
 *         --第二步：创建一个配置类，用于容器启动的时候，自动注入Jedis对象！
 *         --第三步：为了让容器自动加载第三方jar的Bean，需要使用如下二种方式：
 *              --方式一：使用@Import注解，加载对象到容器
 *              --方式二：在META-INF/spring.factories文件中配置，指定装载到容器类路径（推荐使用，简单无依赖）
 * （2）第二步：在当前项目中，测试验证spring-boot-starter-jedis，从容器中注解获取Jedis对象。
 *      类似于其他的start启动类一样！!!
 */
@EnableRedis
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);

        // 直接从自定义的spring-boot-starter-jedis中获取已经装配的Jedis对象
        Jedis jedis = configurableApplicationContext.getBean(Jedis.class);
        jedis.set("hello","world");
        System.out.println(jedis.get("hello"));

        configurableApplicationContext.close();
    }

}
