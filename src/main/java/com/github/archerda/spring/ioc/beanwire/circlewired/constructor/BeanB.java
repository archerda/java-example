package com.github.archerda.spring.ioc.beanwire.circlewired.constructor;

/**
 * @author archerda
 * @date 2018/9/21
 */
public class BeanB {

    private BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }
}
