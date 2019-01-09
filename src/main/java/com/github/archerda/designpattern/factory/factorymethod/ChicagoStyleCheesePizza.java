package com.github.archerda.designpattern.factory.factorymethod;

import com.github.archerda.designpattern.factory.Pizza;

/**
 * Create by archerda on 2017/10/18.
 */
public class ChicagoStyleCheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Prepare Chicago style cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("Bake Chicago style cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cut Chicago style cheese pizza");
    }

    @Override
    public void box() {
        System.out.println("Box Chicago style cheese pizza");
    }
}
