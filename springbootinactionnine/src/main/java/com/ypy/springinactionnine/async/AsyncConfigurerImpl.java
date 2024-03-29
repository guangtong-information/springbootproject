package com.ypy.springinactionnine.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//@Component
public class AsyncConfigurerImpl implements AsyncConfigurer {

    public Executor getAsyncExecutor() {
        System.out.println("====================start asyncServiceExecutor====================");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(2);
        //配置最大线程数
        executor.setMaxPoolSize(4);
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(30000);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-service-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        /*executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);*/
        //执行初始化
        executor.initialize();
        return executor;
    }

    /*异步任务中异常处理*/
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        // TODO Auto-generated method stub
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
