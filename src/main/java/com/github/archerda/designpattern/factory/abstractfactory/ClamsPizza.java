package com.github.archerda.designpattern.factory.abstractfactory;

/**
 * Create by archerda on 2017/11/05.
 */
public class ClamsPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public ClamsPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        clams = pizzaIngredientFactory.createClams();
    }
}
