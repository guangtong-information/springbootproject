package com.ypy.springinactionnine;

import com.ypy.springinactionnine.async.Jeep2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.TimeUnit;

/**
 *
 * 知识点2：@EnableAsync:开启新特性：启用异步执行功能
 * 需要和@Async注解一起使用，才能开启异步执行的新特性
 *
 * 注意：
 * （1）简单说就是没有过去到代理类,本类调用时,直接自己内部调用,没有走代理类
 * （2）异步方法使用注解@Async的返回值只能为void或者Future。
 * （3）https://blog.csdn.net/YoungLee16/article/details/88398045
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.ypy.springinactionnine.async"})
public class App2 {

    /*@Async
    public void test() {
        try{
            for(int i=1;i<3;i++){
                System.out.println(Thread.currentThread().getName() + "----------------"+i);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public boolean test(Jeep2 jeep2){
        return jeep2.test();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App2.class,args);

        for (int i=0;i<5;i++) {
            configurableApplicationContext.getBean(App2.class).test(configurableApplicationContext.getBean(Jeep2.class));
        }

//        System.out.println(Thread.currentThread().getName() + "----------end----------");
//        configurableApplicationContext.close();
    }

}