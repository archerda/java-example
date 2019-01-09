package com.github.archerda.designpattern.decorator;

/**
 * 具体组件；
 *
 * 浓缩咖啡类；
 *
 * 首先，让 Coffee 继承自 Beverage类，因为 Coffee 是一种饮料；
 *
 * Create by archerda on 2017/08/24.
 */
public class Coffee extends Beverage {

    public Coffee() {
        description = "Coffee";
    }

    @Override
    public double cost() {
        return 10.00;
    }
}
