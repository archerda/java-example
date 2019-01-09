package com.github.archerda.designpattern.factory.simplefactory;

import com.github.archerda.designpattern.factory.Pizza;

/**
 * Create by archerda on 2017/10/17.
 */
public class PizzaStore {

    private SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
