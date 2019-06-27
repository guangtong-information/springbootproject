package com.ypy.springbootinactionfifteen.seventeenweb3.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟500异常，调用自定义异常处理页面
 */
@RestController
public class ExceptionController {

    @GetMapping("/exceptionpage")
    public String exceptionPage(){
        throw  new IllegalArgumentException("模拟异常！");
    }

}
