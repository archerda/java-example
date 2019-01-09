package com.github.archerda.designpattern.factory.abstractfactory;

import com.github.archerda.designpattern.factory.abstractfactory.ingredient.*;

/**
 * 具体工厂
 *
 * Create by archerda on 2017/11/05.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
