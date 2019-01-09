package com.github.archerda.spring.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * AOP通知测试切面；
 *
 * @author archerda
 * @date 2018/7/13
 */
@Component("aopAdviceTestAspect")
public class AopAdviceTestAspect {

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around start");
        pjp.proceed();
        System.out.println("around end");
    }

    public void before(JoinPoint pjp) {
        System.out.println("before");
    }

    public void after(JoinPoint pjp) {
        System.out.println("after");
    }

    public void afterReturning(JoinPoint pjp) {
        System.out.println("afterReturning");
    }

    public void afterThrowing(JoinPoint pjp) {
        System.out.println("afterThrowing");
    }

}
