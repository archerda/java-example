package com.github.archerda.designpattern.decorator;

/**
 * 抽象组件；
 *
 * 饮料类；
 *
 * Beverage 是一个抽象类，有两个方法：getDescription() 和 cost();
 * getDescription() 已经在此实现了，但是 cost()必须在子类实现；
 *
 * Create by archerda on 2017/08/24.
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public abstract double cost();

    public String getDescription() {
        return description;
    }
}
