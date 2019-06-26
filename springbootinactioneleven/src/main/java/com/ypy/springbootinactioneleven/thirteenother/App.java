package com.ypy.springbootinactioneleven.thirteenother;

import com.google.gson.Gson;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点1：@SpringBootApplication注解参数，scanBasePackages默认扫描包为当前启动类（启动源）所在的包及其子包
 *
 * 知识点2：@SpringBootApplication注解参数，容器启动的时候，exclude排除加载某些Bean到容器中
 * 注意：spring-boot-autoconfigure.jar默认会有很多配置类，当发现POM中增加某些依赖的时候，容器启动的时候，会自动添加这些依赖的Bean到容器中
 * 详见“10 Springboot @EnableAutoConfigration分析和外部化依赖Bean加载到容器的案例演示”
 * 例如Gson
 *
 * 知识点3：启动banner
 * （1）关闭springboot启动时的banner，SpringApplication.setBannerMode(Banner.Mode.OFF)
 * （2）在resources/my.txt，可以自定义springboot启动banner，注意文件名一定要为banner.txt
 * （3）或者也可以在配置文件中，指定spring.banner.location=my.txt,实现自定义文件名
 * （4）还可以指定图片的banner，知识格式为jpg,png,jpg。默认在resources/banner.jpg文件即可
 * （5）或者也可以在配置文件中，指定spring.banner.image.location=my.jpg,实现自定义文件名
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactioneleven.thirteenother"},exclude = GsonAutoConfiguration.class)
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        // 关闭springboot启动时的Banner
//        springApplication.setBannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);

        // 已经使用exclude，容器启动的时候，不加载Gson包含的Bean
//        System.out.println(configurableApplicationContext.getBean(Gson.class));

        configurableApplicationContext.close();
    }

}
