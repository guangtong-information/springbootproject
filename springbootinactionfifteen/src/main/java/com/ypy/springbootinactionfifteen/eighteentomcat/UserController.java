package com.ypy.springbootinactionfifteen.eighteentomcat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/home")
    public String home(){
        return "user home";
    }

}
