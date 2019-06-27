package com.ypy.springbootinactionfifteen.fifteenweb1.controller.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    // 知识点1：创建一个web请求（体现Springboot的快速开发优势！）
    @RequestMapping(value = "/user/home",method = RequestMethod.GET)//method指定请求方式，使用postman来测试
    @ResponseBody // 方法的返回值直接渲染到页面
    public String home(){
        return "user home";
    }

    // 知识点2：指定请求类型
    @GetMapping(value = "/user/show")//@GetMapping、@PostMapping spring4.3.0的新特性
    @ResponseBody
    public String show(){
        return "user show";
    }

    /**
     * 知识点3：获取请求参数
     * @RequestParam 默认必须提供参数，可以通过设置required = false改变默认设置！
     * @PostMapping//默认请求path为方法名
     * URL：
     * http://127.0.0.1:8080/create?username=123&password=1
     */
    @PostMapping("/user/create")
    @ResponseBody
    public String create(@RequestParam(value = "username",required = false)String username,@RequestParam(value = "password")String password){
        return "user create:" + username+":"+password;
    }

    /**
     * 知识点4：获取URL请求字符串
     * 获取URL请求参数的值:{id} + @PathVariable("id")
     * URL:
     * http://127.0.0.1:8080/user/1
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public String display(@PathVariable("id")String id){
        return "id:" + id;
    }

    // 知识点5：注入Servlet对象
    @GetMapping("/user/ip")
    @ResponseBody
    public String edit(HttpServletRequest httpServletRequest){
        return "ip"+httpServletRequest.getRemoteHost();
    }
}
