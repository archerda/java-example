package com.github.archerda.designpattern.decorator;

/**
 * 具体组件；
 *
 * Create by archerda on 2017/08/24.
 */
public class Tea extends Beverage {

    public Tea() {
        description = "Tea";
    }

    @Override
    public double cost() {
        return 8;
    }
}
