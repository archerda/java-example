package com.github.archerda.designpattern.factory.abstractfactory;

import com.github.archerda.designpattern.factory.abstractfactory.ingredient.*;

/**
 * Create by archerda on 2017/11/05.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
