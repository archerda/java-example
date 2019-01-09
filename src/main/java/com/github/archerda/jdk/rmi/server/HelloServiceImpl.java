package com.github.archerda.jdk.rmi.server;

import com.github.archerda.jdk.rmi.HelloService;

/**
 * 远程接口实现类；
 *
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
