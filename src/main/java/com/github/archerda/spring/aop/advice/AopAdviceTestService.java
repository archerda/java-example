package com.github.archerda.spring.aop.advice;

/**
 * AOP通知测试接口；
 *
 * @author archerda
 * @date 2018/7/13
 */
public interface AopAdviceTestService {

    String sayHi(String name);

    String throwException() throws Throwable;
}
