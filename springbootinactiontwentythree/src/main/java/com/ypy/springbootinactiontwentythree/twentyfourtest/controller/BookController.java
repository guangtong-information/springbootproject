package com.ypy.springbootinactiontwentythree.twentyfourtest.controller;

import com.ypy.springbootinactiontwentythree.twentyfourtest.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller的测试
 */
@RestController
public class BookController {

/*    @Autowired
    private UserDao userDao;*/

    @GetMapping("/home")
    public String home(){
        System.out.println("bookhome");
        return "bookhome";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id")String id){
        System.out.println("show");
        return "show" + id;
    }

}
