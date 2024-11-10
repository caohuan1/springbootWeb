package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.itheima.service.*.*(..))")//切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //记录方法的开始执行时间
        long begin = System.currentTimeMillis();
        //运行原始方法
        Object result = joinPoint.proceed();
        //记录方法的结束时间
        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature()+"方法执行耗时为"+(end-begin)+"ms");
        return result;
    }
}
