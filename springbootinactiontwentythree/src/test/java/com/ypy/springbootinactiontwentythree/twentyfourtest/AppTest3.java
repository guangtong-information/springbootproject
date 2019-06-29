package com.ypy.springbootinactiontwentythree.twentyfourtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 知识点4：Env环境配置的测试：设置和获取配置文件的三种方式
 * （1）方式一：在配置文件中设置配置项
 *      --并使用Environment获取 ,或者ConfigurableEnvironment获取配置项内容
 *      --优先获取测试环境的配置文件 application.xml或者application.yml，如果没有在去正式环境下的配置文件
 *
 * （2）方式二：在测试启动类注解上增加配置项：@SpringBootTest(properties = {"app.version=1.0.0"})
 *
 * @author Ryan
 * @date 2019/4/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app.version=1.0.0"})
public class AppTest3 {

//    @Autowired
//    private Environment environment;

    @Autowired
    private ConfigurableEnvironment environment;

    @Test
    public void testValue(){
        Assert.assertEquals("优先获取测试环境的配置文件，如果没有在去正式环境下的配置文件", environment.getProperty("test"));
        Assert.assertEquals("1.0.0",environment.getProperty("app.version"));
    }
}
