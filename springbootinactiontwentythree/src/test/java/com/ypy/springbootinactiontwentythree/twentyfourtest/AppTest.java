package com.ypy.springbootinactiontwentythree.twentyfourtest;

import com.ypy.springbootinactiontwentythree.twentyfourtest.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot测试
 * 知识点1：写一个简单的测试类（针对Service或者Dao的测试）
 * （1）添加测试的依赖
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-test</artifactId>
 *             <scope>test</scope>
 *         </dependency>
 *
 *  （2）在测试类上添加如下二个注解即可
 *  @RunWith(SpringRunner.class)
 *  @SpringBootTest
 *
 *  （3）注意：一定要定义主启动类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})//指定启动类，可以不指定，当前程序会主动查找
public class AppTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAddUser(){
        Assert.assertEquals(Integer.valueOf(1),userDao.addUser("root"));
        Assert.assertEquals(Integer.valueOf(1),userDao.addUser(""));
        Assert.assertEquals(Integer.valueOf(0),userDao.addUser(null));
    }

}
