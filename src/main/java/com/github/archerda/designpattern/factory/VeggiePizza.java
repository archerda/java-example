package com.github.archerda.designpattern.factory;

/**
 * 素食披萨
 *
 * Create by archerda on 2017/10/17.
 */
public class VeggiePizza implements Pizza {

    public void prepare() {
        System.out.println("Prepare VeggiePizza");
    }

    public void bake() {
        System.out.println("Bake VeggiePizza");
    }

    public void cut() {
        System.out.println("Cut VeggiePizza");
    }

    public void box() {
        System.out.println("Box VeggiePizza");
    }
}
