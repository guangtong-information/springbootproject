package com.ypy.springbootinactionfifteen.seventeenweb3.globalexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobeExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String errorHandler(Exception e){
        return "global error handler" + e.getClass();
    }
}
