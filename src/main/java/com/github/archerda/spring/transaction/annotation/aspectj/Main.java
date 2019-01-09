package com.github.archerda.spring.transaction.annotation.aspectj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author archerda
 * @date 2018/7/17
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/transaction/annotation/applicationContextAspectj.xml");

        applicationContext.start();

        UserService userService = (UserService) applicationContext.getBean("userServiceAnnotationAspectj");

        userService.updateNameAndAgeWithTransaction(1, "updateNameAndAgeWithTransaction", 111);
        userService.updateNameAndAgeThrowExceptionWithTransaction(1, "updateNameAndAgeThrowExceptionWithTransaction", 111);

        applicationContext.close();
    }
}
