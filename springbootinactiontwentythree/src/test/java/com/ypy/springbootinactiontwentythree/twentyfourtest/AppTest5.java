package com.ypy.springbootinactiontwentythree.twentyfourtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 知识点6：Controller的测试,方式一：使用TestRestTemplate
 * （1）在测试的时候，需要首先启动web容器（内嵌的web环境），才能测试Controller
 * （2）所以需要在@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT),指定web环境，使用随机的一个端口
 * （3）在程序启动的时候，启动一个内嵌的web环境
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest5 {

    @Autowired
    private TestRestTemplate restTemplate;

    // 不带参数的Controller测试
    @Test
    public void testHome(){
        String context = restTemplate.getForObject("/home",String.class);
        Assert.assertEquals("bookhome",context);
    }

    // 带参数的Controller测试
    @Test
    public void testShow(){
        String context = restTemplate.getForObject("/show?id=100",String.class);
        Assert.assertEquals("show100",context);
    }

}
