package com.github.archerda.designpattern.factory.abstractfactory;

/**
 * 创建者
 *
 * Create by archerda on 2017/10/18.
 */
public abstract class PizzaStore {

    // 工厂方法；
    // abstract Product factoryMethod(String type);
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
