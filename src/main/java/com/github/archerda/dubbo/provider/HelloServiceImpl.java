package com.github.archerda.dubbo.provider;

/**
 * @author archerda
 * @date 2018/7/25
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }
}
