package com.github.archerda.spring.ioc.beanwire.circlewired.setter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 构造器循环依赖Demo
 *
 * @author archerda
 * @date 2018/9/21
 */
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("spring/ioc/circlewired/setter/applicationContext.xml");

        applicationContext.start();

        BeanA demo = (BeanA) applicationContext.getBean("beanA");

        System.out.println(demo);
    }
}
