package com.ypy.springbootinactiontwentythree.twentyfourtest;

import com.ypy.springbootinactiontwentythree.twentyfourtest.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 知识点7：Controller测试，方式二：使用WebMvcTest
 * （1）WebMvcTest，不需要运行在web环境，但是需要指定Controller，标识测试那个Controller对象；
 * （2）WebMvcTest使用的是mock方式，不需要像知识点5那样，需要启动一个真正的容器！
 * （3）所以：使用WebMvcTest是有局限性的！
 * （4）注意：这种方法只是测试Controller，Controller里面的依赖需要自己Mock！
 *      因为使用WebMvcTest不会加载整个spring容器！只能使用知识点5的TestRestTemplate方式！
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class AppTest6 {
    @Autowired
    private MockMvc mockMvc;

    // 不带参数的Controller测试
    @Test
    public void testHome() throws Exception{
        //期待Http响应状态为OK
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk());
        //期待Http响应状态为OK，同时响应结果为bookhome
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("bookhome"));
    }

    // 带参数的Controller测试
    @Test
    public void testShow() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/show").param("id","100")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/show").param("id","100")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("show100"));
    }
}
