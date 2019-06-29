package com.ypy.springbootinactiontwentythree.twentyfourtest;

import com.ypy.springbootinactiontwentythree.twentyfourtest.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 知识点2：ApplicationContext测试
 * 获取ApplicationContext的测试
 *
 * 知识点3：仅在测试环境装配的Bean
 *（1）添加Test环境的装配类：@SpringBootTest(classes = TestBeanConfiguration.class)
 *
 * @author Ryan
 * @date 2019/4/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestBeanConfiguration.class)
public class AppTest2 {

    @Autowired
    private ApplicationContext applicationContext;

    // 测试ApplicationContext
    @Test
    public void testBean(){
        Assert.assertNotNull(applicationContext.getBean(User.class));
    }

    // 测试装配类的测试类
    @Test
    public void testConfiguration(){
        Assert.assertNotNull(applicationContext.getBean(Runnable.class));
    }
}
