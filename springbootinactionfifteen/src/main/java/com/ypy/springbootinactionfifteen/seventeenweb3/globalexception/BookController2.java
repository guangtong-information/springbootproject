package com.ypy.springbootinactionfifteen.seventeenweb3.globalexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

/**
 * 测试全局异常处理类
 */
@RestController
public class BookController2 {

    @GetMapping("/error3")
    public String error1() throws FileNotFoundException {
        throw new FileNotFoundException("文件未找到！");
    }


}
