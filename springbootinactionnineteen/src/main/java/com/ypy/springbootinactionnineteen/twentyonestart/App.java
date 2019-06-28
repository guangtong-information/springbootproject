package com.ypy.springbootinactionnineteen.twentyonestart;

import com.ypy.springbootstartjedis.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * 知识点：自定义springboot的start启动类
 *
 *
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
