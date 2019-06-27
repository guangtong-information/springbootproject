package com.ypy.springbootinactionfifteen.fifteenweb1.controller.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 知识点9：在springboot-web项目中，使用freemarker模版
 * （1）添加依赖
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-freemarker</artifactId>
 *         </dependency>
 * （2）默认模版文件都放在classpath:/templates/目录之下，默认的文件扩展名为.flt
 * （3）具体可见：spring-boot-autoconfig.jar下的FreeMarkerProperties类
 * （4）用于
 *
 */
@Controller// 不能使用@RestController
public class AccountController {

    @GetMapping("/reg")
    public String reg(){
        // 默认会找classpath/templates/reg.ftl 模板文件
        return "reg";
    }

    /**
     * 知识点9：在freemarker中传递参数，使用Model对象
     * 类似Request.setattribute设置属性值一样！
     */
    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("username","admin");
        model.addAttribute("logout","true");
        return "logout";
    }
}
