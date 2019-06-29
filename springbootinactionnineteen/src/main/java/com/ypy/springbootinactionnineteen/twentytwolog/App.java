package com.ypy.springbootinactionnineteen.twentytwolog;

import com.ypy.springbootinactionnineteen.twentytwolog.dao.UserDao;
import com.ypy.springbootinactionnineteen.twentytwolog.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * springboot默认使用logback作为日志处理
 * 知识点1：springboot配置文件设置log
 * 第一：springboot的log级别默认为info，可以通过如下方式更改默认级别：
 * （1）方式一：application.properties中设置：logging.level.root=debug
 * （2）方式二：在启动参数中设置（该方式只会输出springboot内部的debug，不会更改项目的日志级别）
 *      -Dlogging.level.root=debug
 * （3）方式三：可以单独设置某个包或者类的日志级别
 *      logging.level.com.ypy.springbootinactionnineteen.twentytwolog.service=debug
 * （4）注意：日志级别有8种：OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。
 *
 * 第二：指定日志文件的路径（默认文件名为spring.log）和名称（log大小超过10M，就会自动分割）
 * logging.path=c:/tmp
 * logging.file=c:/tmp/my.log
 *
 * 第三：可以指定控制台和文件的日志输出格式
 * -控制台的
 * logging.pattern.console=XXX
 * -文件的
 * logging.pattern.file=XXX
 *
 * 知识点2：以上做法不推荐，推荐使用logback配置文件的方式来更改springboot的日志输出
 * （1）springboot默认使用logback作为日志框架
 * （2）在classpath目录下，增加logback.xml配置文件即可
 * （3）在classpath目录下，增加logback-spring.xml配置文件也可以，springboot官方推荐
 *
 * 知识点3：不使用默认的logback，使用log4j2做日志处理框架
 * （1）排除logback的依赖
 * （2）引入log4j2的依赖
 * （3）新增log4j2.xml的配置文件
 * （4）注意：屏蔽logback的配置文件（logback-spring.xml重命名为0logback-spring.xml）
 *
 * 知识点4：springboot log相关的源码
 * spring-boot.jar logging目录下
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionnineteen.twentytwolog"})
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        configurableApplicationContext.getBean(UserDao.class).log();
        System.out.println("------------------------------");
        configurableApplicationContext.getBean(UserService.class).log();
        configurableApplicationContext.close();
    }

}
