package com.github.archerda.spring.aop.advice;

import org.springframework.stereotype.Service;

/**
 * AOP通知测试接口实现类；
 *
 * @author archerda
 * @date 2018/7/13
 */
@Service("aopAdviceTestService")
public class AopAdviceTestServiceImpl implements AopAdviceTestService {

    @Override
    public String sayHi(String name) {
        System.out.println("Hi " + name);
        return "Hi";
    }

    @Override
    public String throwException() throws Throwable {
        System.out.println("throwException...");
        throw new Throwable("throwException...");
    }
}
