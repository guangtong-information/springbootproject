package com.ypy.springbootinactionfifteen.fifteenweb1.controller.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 知识点6【重要】
 * 使用RestController，表明当前Controller下的方法的返回值，
 * 可以直接作为body输出到页面，就不需要在每个方法上写@ResponseBody
 */
@RestController
public class RoleController {

    @GetMapping("/role/show")
    public String show(){
        return "role show";
    }

}
