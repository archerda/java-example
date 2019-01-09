package com.github.archerda.designpattern.factory.abstractfactory;

/**
 * Create by archerda on 2017/11/05.
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza nyCheesePizza = nyPizzaStore.orderPizza("cheese");

        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza chicagoClamsPizza = chicagoPizzaStore.orderPizza("cheese");
    }
}
