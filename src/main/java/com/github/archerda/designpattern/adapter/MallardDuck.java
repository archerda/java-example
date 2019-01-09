package com.github.archerda.designpattern.adapter;

/**
 * Create by archerda on 2017/11/20.
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
