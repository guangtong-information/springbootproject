package com.ypy.springinaction.first.componentanddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class UserServer {

    // 依赖注入的三种方式
//    @Autowired //Spring自带的依赖注入
//    @Resource //JSR 250的依赖注入规范
    @Inject //JSR 330的依赖注入规范
    private UserDao userDao;

    @Override
    public String toString() {
        return "UserServer{" +
                "userDao=" + userDao +
                '}';
    }
}
