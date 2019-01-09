package com.github.archerda.spring.aop.introduce;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by archerda on 2017/11/20.
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("spring/aop/introduce/applicationContext.xml");
        applicationContext.start();

        Performance performance = (Performance) applicationContext.getBean("performance");
        performance.perform();
        ((Encoreable) performance).performEncore();
    }
}
