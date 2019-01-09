package com.github.archerda.designpattern.factory.simplefactory;

import com.github.archerda.designpattern.factory.CheesePizza;
import com.github.archerda.designpattern.factory.Pizza;
import com.github.archerda.designpattern.factory.VeggiePizza;

/**
 * 简单工厂
 *
 * Create by archerda on 2017/10/17.
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
