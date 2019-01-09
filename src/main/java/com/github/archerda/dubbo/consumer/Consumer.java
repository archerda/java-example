package com.github.archerda.dubbo.consumer;

import com.github.archerda.dubbo.provider.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author archerda
 * @date 2018/7/25
 */
public class Consumer {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("classpath:dubbo/consumer.xml");

        applicationContext.start();

        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        String result = helloService.sayHello("Dubbo");
        System.out.println("Result: " + result);

        applicationContext.close();
    }
}
