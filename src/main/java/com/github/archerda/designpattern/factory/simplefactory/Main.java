package com.github.archerda.designpattern.factory.simplefactory;

/**
 * Create by archerda on 2017/10/17.
 */
public class Main {

    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);
        pizzaStore.orderPizza("cheese");
    }
}
