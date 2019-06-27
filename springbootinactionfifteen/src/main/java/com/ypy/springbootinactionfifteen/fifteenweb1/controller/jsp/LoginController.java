package com.ypy.springbootinactionfifteen.fifteenweb1.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 知识点7：在springboot-web项目中使用jsp
 * （1）第一步：需要增加一个依赖
 *         <dependency>
 *             <groupId>org.apache.tomcat.embed</groupId>
 *             <artifactId>tomcat-embed-jasper</artifactId>
 *             <version>9.0.17</version>
 *         </dependency>
 *
 * （2）第二步：在application.properties增加二个配置项
 *      spring.mvc.view.prefix=/WEB-INF/jsp/
 *      spring.mvc.view.suffix=.jsp
 *
 * （3）第三步：编写Controller
 * （4）第四步：编写jsp页面
 * （5）第五步：测试验证
 *
 * 注意：此时不能使用RestController！因为RestController是直接将结果值输出到页面！
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username, @RequestParam("password") String password){
        if (username.equals(password)){
            return "ok";//根据配置文件中定义，系统去找./WEB-INF/jsp/ok.jsp
        } else {
            return "fail";//根据配置文件中定义，系统去找./WEB-INF/jsp/fail.jsp
        }
    }

    /**
     * 知识点8：Model等同于“域对象”（page、request、session、application），用于传递参数
     * URL:
     * http://127.0.0.1:8080/login?username=123
     */
    @GetMapping("login")
    public String loginIndex(@RequestParam(value = "username")String username, Model model){
        model.addAttribute("username",username);
        return "login";
    }
}
