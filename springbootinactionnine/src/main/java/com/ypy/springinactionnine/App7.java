package com.ypy.springinactionnine;

import com.ypy.springinactionnine.myannotation.EnableEcho;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * 知识点7：综合示例演示@Enable*的实现原理
 * 实现业务功能：定义@EnableEcho注解，在其指定的包范围内，所有Bean的装配时，都需要打印监听日志
 * 实现思路：
 * （1）Bean装配的时候，打印日志，可以使用Bean的后置处理器
 * （2）当Bean初始化的时候，在Bean的后置处理器中，根据Bean所在的包，判断是否是监听范围内，
 * （3）如果是，那么打印监听日志；如果不是，则不打印。
 * （4）具体见：com.ypy.springinactionnine.demo.EchoBeanPostProcessor
 *
 * 实现步骤：
 * （1）定义@EnableEcho注解，传入package 字符串数组参数，用于输出监听的包的范围
 * （2）@EnableEcho注解，使用@Import(@EchoImportBeanDefinationRegister.class)实现具体的业务逻辑
 * （3）在EchoImportBeanDefinationRegister实现类中，将后置处理器反射创建出来
 * （4）并且通过反射的方式，在注入参数package
 * （5）最后，将后置处理器，放入容器托管！！！
 *
 * 核心的函数有三个：
 * （1）EchoBeanPostProcessor：负责实现打印监听日志的具体业务逻辑！
 * （2）EchoImportBeanDefinitionRegistrar：负责将EchoBeanPostProcessor动态注入到容器中，加载Bean后置处理器
 * （3）EnableEcho，作为入口，使用@Import注解，传入EchoImportBeanDefinitionRegistrar参数！
 * （4）最终实现业务功能！
 *
 * 【总结】
 * （1）@Enable*的核心，在于@Import注解
 * （2）@Import的核心，在于其参数的实现类
 *
 */
// 第四步：测试验证：实现一个自定义的Enable*注解
@EnableEcho(packages = {"com.ypy.springinactionnine.demo"})
@SpringBootApplication(scanBasePackages = {"com.ypy.springinactionnine.demo"})
public class App7 {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App7.class,args);
        configurableApplicationContext.close();
    }
}
