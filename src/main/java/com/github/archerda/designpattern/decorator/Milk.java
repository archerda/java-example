package com.github.archerda.designpattern.decorator;

/**
 * 具体装饰者；
 *
 * Create by archerda on 2017/08/24.
 */
public class Milk extends CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
