package com.github.archerda.designpattern.observer.custom;

/**
 * 观察者接口；
 * Create by archerda on 2017/08/08.
 */
public interface Observer {

    /**
     * 接受主题的通知；
     * 当主题状态改变时，主题会把这些状态当做方法的参数，传递给观察者；
     *
     * @param temp 温度；
     * @param humidity 湿度；
     * @param pressure 压强；
     */
    void update(float temp, float humidity, float pressure);
}
