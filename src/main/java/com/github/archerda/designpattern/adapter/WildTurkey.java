package com.github.archerda.designpattern.adapter;

/**
 * Create by archerda on 2017/11/20.
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
