package com.github.archerda.spring.ioc.beanwire.circlewired.setter;

/**
 * @author archerda
 * @date 2018/9/21
 */
public class BeanB {

    private BeanA beanA;

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
