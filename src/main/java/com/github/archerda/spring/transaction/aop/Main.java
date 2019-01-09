package com.github.archerda.spring.transaction.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author archerda
 * @date 2018/7/18
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/transaction/aop/applicationContext.xml");

        applicationContext.start();

        UserService userService = (UserService) applicationContext.getBean("userServiceAop");

        userService.updateNameAndAgeWithTransaction(1, "updateNameAndAgeWithTransaction", 111);
        userService.updateNameAndAgeThrowExceptionWithTransaction(1, "updateNameAndAgeThrowExceptionWithTransaction", 222);

        applicationContext.close();
    }
}
