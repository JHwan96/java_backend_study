package com.example.filter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut(value = "within(com.example.filter.controller.UserApiController)")
    public void timerPointCut(){

    }

    @Before(value = "timerPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }

    @After(value = "timerPointCut()")
    public void after(JoinPoint jointPoint) {
        System.out.println("after");
    }

    @AfterReturning(value = "timerPointCut()")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("after returning");
    }

    @AfterThrowing(value = "timerPointCut()")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex){
        System.out.println("after throwing");
    }

    @Around(value = "timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        joinPoint.proceed();
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println("메소드 실행 이후");
    }
}
