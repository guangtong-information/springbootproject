package com.ypy.springbootinactioneleven.twelveextend.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 在spring容器全部加载完最后一步前，回调该接口
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("应用已经启动，参数为：" + Arrays.asList(args.getSourceArgs()));
    }
}
