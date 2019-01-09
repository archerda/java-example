package com.github.archerda.designpattern.adapter;

/**
 * Adapter：适配器
 *
 * Create by archerda on 2017/11/20.
 */
public class TurkeyAdapter implements Duck {

    // Adaptee：被适配者
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
