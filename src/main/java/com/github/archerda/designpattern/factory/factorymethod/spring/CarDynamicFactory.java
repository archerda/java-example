package com.github.archerda.designpattern.factory.factorymethod.spring;

import java.util.Map;

/**
 * Create by archerda on 2017/11/09.
 */
public class CarDynamicFactory {

    private Map<String, Car> carMap;

    public Car getCar(String name) {
        return carMap.get(name);
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }
}
