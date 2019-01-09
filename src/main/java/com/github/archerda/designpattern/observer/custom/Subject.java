package com.github.archerda.designpattern.observer.custom;

/**
 * 主题接口；
 * Create by archerda on 2017/08/08.
 */
public interface Subject {

    /**
     * 观察者注册；
     */
    boolean registerObserver(Observer observer);

    /**
     * 观察者取消注册；
     */
    boolean removeObserver(Observer observer);

    /**
     * 当主题状态改变时，这个方法会被调用，用于通知所有的观察者；
     */
    boolean notifyObservers();
}
