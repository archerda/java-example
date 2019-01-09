package com.github.archerda.designpattern.factory.abstractfactory;

/**
 * Create by archerda on 2017/11/05.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equals("clams")) {
            pizza = new ClamsPizza(pizzaIngredientFactory);
            pizza.setName("New York Style Clams Pizza");
        }

        return pizza;
    }
}
