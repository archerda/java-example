package com.github.archerda.dubbo.provider;

/**
 * @author archerda
 * @date 2018/7/25
 */
public class MockHelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("Mock " + name);
        return "Mock " + name;
    }
}
