package com.ypy.springbootinactiontwo.fivestartspringboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * @SpringBootApplication是多个注解的复合体
 * （1）@ComponentScan 自动扫描包
 * 默认是从源开始扫描包，一般要把源放在最外层，所以他可以自动加载User对象
 *
 * （2）@SpringBootConfiguration 配置类
 * 所以可以在源对象里面装配Bean，一般不推荐这么做
 *
 * （3）@EnableAutoConfiguration 开启自动加载Configuration
 * 所有符合条件的@Configuration配置都加载到当前Springboot的IOC容器当中
 *
 */
@SpringBootApplication
public class App {

    /**
     * 定义一个Bean
     * 因为App是Springboot的启动源，源本身就是一个配置类，所以可以在配置类中装配一个Bean
     * 不过：一般不会这样做！！！
     */
    @Bean
    public Runnable createRunnable(){
        // lambda表达式
        return () ->{
            System.out.println("spring boot is run");
        };
       /*return new Runnable() {
           @Override
           public void run() {
                System.out.println("spring boot is run");
           }
       };*/
    }

    public static void main(String[] args) {

        // 知识点1:启动springboot
        // 注意，启动的时候，是可以指定多个源，不过一般就一个！
        // 方式一
//        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);

        // 方式二
        SpringApplication springApplication = new SpringApplication(App.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);

        configurableApplicationContext.getBean(Runnable.class).run();
        System.out.println(configurableApplicationContext.getBean(User.class));
    }

}
