package com.github.archerda.spring.transaction.programming;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author archerda
 * @date 2018/7/18
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/transaction/programing/applicationContext.xml");

        applicationContext.start();

        UserService userService = (UserService) applicationContext.getBean("userServicePrograming");

        userService.updateNameAndAgeWithTransaction(1, "updateNameAndAgeWithTransaction", 111);
        userService.updateNameAndAgeThrowExceptionWithTransaction(1, "updateNameAndAgeThrowExceptionWithTransaction", 222);

        applicationContext.close();
    }
}
