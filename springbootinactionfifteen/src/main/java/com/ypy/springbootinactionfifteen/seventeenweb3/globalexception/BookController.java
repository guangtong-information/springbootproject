package com.ypy.springbootinactionfifteen.seventeenweb3.globalexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

/**
 * 局部的异常处理类
 */
@RestController
public class BookController {

//    @ExceptionHandler(value = FileNotFoundException.class)
    @ExceptionHandler(value = Exception.class)
    public String error(Exception e){
        return "捕获到异常，异常堆栈信息为：" + e.getStackTrace();
    }

    @GetMapping("/error1")
    public String error1() throws FileNotFoundException {
        throw new FileNotFoundException("文件未找到！");
    }

    @GetMapping("/error2")
    public String error2() throws ClassNotFoundException{
        throw new ClassNotFoundException("class未找到！");
    }

}
