package com.ypy.springbootinactioneleven.twelveextend.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在spring容器全部加载完最后一步前，回调该接口
 */
@Order(1)
@Component
public class ServerSuccessReport implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("===============应用已经成功启动！我是第1个执行！=============");
    }
}
