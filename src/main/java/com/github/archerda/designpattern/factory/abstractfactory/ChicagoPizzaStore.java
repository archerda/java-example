package com.github.archerda.designpattern.factory.abstractfactory;

/**
 * Create by archerda on 2017/11/05.
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (type.equals("clams")) {
            pizza = new ClamsPizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Clams Pizza");
        }

        return pizza;
    }
}
