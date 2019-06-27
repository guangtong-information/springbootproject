package com.ypy.springbootinactionfifteen.seventeenweb3.exception;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 实现ErrorPageRegistrar接口，实现自定义的异常处理业务逻辑！并将该实现类，纳入到容器；
 * --可以针对异常响应码处理
 * --或者针对异常类型处理
 */
@Component
public class CommonErrorPageRegistery implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/exception/404.html");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/exception/500.html");
        ErrorPage illegalArgumentException = new ErrorPage(IllegalArgumentException.class,"/exception/IllegalArgumentException.html");
        registry.addErrorPages(e404,e500,illegalArgumentException);
    }
}
