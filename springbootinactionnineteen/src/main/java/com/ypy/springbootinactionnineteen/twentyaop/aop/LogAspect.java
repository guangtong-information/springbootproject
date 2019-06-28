package com.ypy.springbootinactionnineteen.twentyaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 定义一个简单的切面
 * （1）什么是AOP：
 *      将分散在业务代码的相同代码（具备横切特性的代码--增强Advice），抽离出来，
 *      然后通过相关技术（代理-切面）融合（织入）到业务逻辑代码（切点、连接点、目标对象）
 * （2）切面Advisor=Pointcut(切点) + Adviser（增强）
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 整个execution表达式分为五个部分：
     * 1、第一个*号：表示返回类型，*号代表所有的类型
     * 2、包名：表示需要拦截的包名，后面的二个.号表示当前包和当前包的所有子包
     * 3、第二个*号：表示类名，*号表示所有的类
     * 4、*(..)：最后这个*号表示方法名，*号代表所有的方法，后面的括号代表方法的参数，二个.号表示任何参数
     */
    @Before("execution(* com.ypy.springbootinactionnineteen.twentyaop.dao..*.*(..))")
    public void log(){
        System.out.println("before:method log done");
    }

    @After("execution(* com.ypy.springbootinactionnineteen.twentyaop.dao..*.*(..))")
    public void log1(JoinPoint joinPoint){
        System.out.println("getTarget:" + joinPoint.getTarget() + " getArgs:" +joinPoint.getArgs() + " getName:" + joinPoint.getSignature().getName());
        System.out.println("after:method log done");
    }

}
