package com.github.archerda.designpattern.factory.factorymethod;

import com.github.archerda.designpattern.factory.Pizza;

/**
 * Create by archerda on 2017/10/18.
 */
public class NYStylePizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new NYStyleCheesePizza();
        } else if ("veggie".equals(type)) {
            pizza = new NYStyleVeggiePizza();
        }

        return pizza;
    }
}
