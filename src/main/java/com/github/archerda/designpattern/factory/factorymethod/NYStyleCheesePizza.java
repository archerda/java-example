package com.github.archerda.designpattern.factory.factorymethod;

import com.github.archerda.designpattern.factory.Pizza;

/**
 * Create by archerda on 2017/10/18.
 */
public class NYStyleCheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Prepare NY style cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("Bake NY style cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cut NY style cheese pizza");
    }

    @Override
    public void box() {
        System.out.println("Box NY style cheese pizza");
    }
}
