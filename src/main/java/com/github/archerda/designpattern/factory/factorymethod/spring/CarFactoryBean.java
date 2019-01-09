package com.github.archerda.designpattern.factory.factorymethod.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * Create by archerda on 2017/11/09.
 */
public class CarFactoryBean implements FactoryBean {

    private String carName;

    // 这个就是你想利用工厂类生产的bean对象，通常在里面new一个对象就ok
    public Object getObject() throws Exception {
        return new Car(carName);
    }

    // 必须指明为上面getObject返回对象的class
    public Class<?> getObjectType() {
        return Car.class;
    }

    // 这个方法决定了这个bean是否单例
    public boolean isSingleton() {
        return true;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
