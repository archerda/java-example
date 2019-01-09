package com.github.archerda.designpattern.factory;

/**
 * 芝士披萨
 *
 * Create by archerda on 2017/10/17.
 */
public class CheesePizza implements Pizza {

    public void prepare() {
        System.out.println("Prepare CheesePizza");
    }

    public void bake() {
        System.out.println("Bake CheesePizza");
    }

    public void cut() {
        System.out.println("Cut CheesePizza");
    }

    public void box() {
        System.out.println("Box CheesePizza");
    }
}
