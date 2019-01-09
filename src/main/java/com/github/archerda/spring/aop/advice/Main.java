package com.github.archerda.spring.aop.advice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author archerda
 * @date 2018/7/13
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/aop/advice/applicationContext.xml");

        AopAdviceTestService aopAdviceTestService;
        aopAdviceTestService = (AopAdviceTestService) applicationContext.getBean("aopAdviceTestService");

        aopAdviceTestService.sayHi("Archerda");

        System.out.println("---------------------------");

        aopAdviceTestService.throwException();
    }
}
