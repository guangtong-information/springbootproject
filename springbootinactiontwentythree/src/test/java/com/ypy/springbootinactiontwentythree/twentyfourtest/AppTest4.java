package com.ypy.springbootinactiontwentythree.twentyfourtest;

import com.ypy.springbootinactiontwentythree.twentyfourtest.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *知识点5：Mock测试
 */
@RunWith(SpringRunner.class)
public class AppTest4 {

    @MockBean
    private UserMapper userMapper;

    @Before
    public void init(){
        /**
         * 第一步：预测
         */
        BDDMockito.given(userMapper.createUser("admin")).willReturn(1);
        BDDMockito.given(userMapper.createUser("")).willReturn(0);
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);
    }

    // 基于第一步的预测，当输入null的时候，返回异常，所以预测会出现空指针异常，否则单元测试跑不过！
    @Test(expected = NullPointerException.class)
    public void testCreateUser(){
        // 第二步：测试
        Assert.assertEquals(Integer.valueOf(1),userMapper.createUser("admin"));
        Assert.assertEquals(Integer.valueOf(0),userMapper.createUser(""));
        Assert.assertEquals(Integer.valueOf(0),userMapper.createUser(null));
    }
}
