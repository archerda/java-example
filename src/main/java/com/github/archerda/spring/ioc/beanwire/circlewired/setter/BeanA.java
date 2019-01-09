package com.github.archerda.spring.ioc.beanwire.circlewired.setter;

/**
 * @author archerda
 * @date 2018/9/21
 */
public class BeanA {

    private BeanB beanB;

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }
}
