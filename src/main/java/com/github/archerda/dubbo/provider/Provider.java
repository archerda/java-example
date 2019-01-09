package com.github.archerda.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author archerda
 * @date 2018/7/25
 */
public class Provider {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("classpath:dubbo/provider.xml");

        applicationContext.start();

        System.in.read();

        applicationContext.close();
    }
}
