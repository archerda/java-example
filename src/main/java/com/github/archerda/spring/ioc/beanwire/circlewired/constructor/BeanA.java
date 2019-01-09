package com.github.archerda.spring.ioc.beanwire.circlewired.constructor;

/**
 * @author archerda
 * @date 2018/9/21
 */
public class BeanA {

    private BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }
}
