package com.ypy.springbootinactionnineteen.twentyaop;

import com.ypy.springbootinactionnineteen.twentyaop.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 1、知识点1：编写简单的切面示例
 * （1）加入依赖 spring-boot-start-aop，默认开启了面向切面编程的支持
 * （2）编写一个@ASpect切面，编写增强和切入点，实现切面的织入。使用@Component注解将切面托管到容器
 * （3）测试验证
 * （4）spting-boot-autoconfig.jar AopAutoConfiguration 定义了aop的配置：
 *      spring.aop.auto=true 默认开启aop的功能
 *      spring.aop.proxy-target-class=false 默认使用jdk的反向代理 true的时候使用CGLib反向代理
 * （5）注意：如果切面是基于类的，没有基于接口，动态代理的默认都是CGLIB
 *
 * 2、知识点2：获取代理对象
 * 增强传入JointPoint对象参数，可以获取目标代理对象！
 *
 * 3、知识点3：开启AOP功能的三种方式
 * （1）推荐使用：导入spring-boot-start-aop依赖的时候，默认自动开启AOP功能！
 * （2）在配置文件中开启spring.aop.auto=true设置。默认也是开启的。
 * （3）启动类上增加@EnableAspectJAutoProxy注解。默认可不写。
 */
//@EnableAspectJAutoProxy
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class,args);
        configurableApplicationContext.getBean(UserDao.class).add("admin","123456");
        configurableApplicationContext.close();
    }

}
