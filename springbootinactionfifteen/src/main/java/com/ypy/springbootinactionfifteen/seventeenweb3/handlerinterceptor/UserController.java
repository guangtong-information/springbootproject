package com.ypy.springbootinactionfifteen.seventeenweb3.handlerinterceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第三步：定义测试类
 */
@RestController
public class UserController {
    @GetMapping("/user/home")
    public String home(){
        System.out.println("------home controller-------");
        return "user home";
    }
}
