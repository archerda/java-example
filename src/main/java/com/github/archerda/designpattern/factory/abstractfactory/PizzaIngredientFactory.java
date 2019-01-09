package com.github.archerda.designpattern.factory.abstractfactory;

import com.github.archerda.designpattern.factory.abstractfactory.ingredient.Clams;
import com.github.archerda.designpattern.factory.abstractfactory.ingredient.Dough;
import com.github.archerda.designpattern.factory.abstractfactory.ingredient.Sauce;

/**
 * 抽象工厂
 *
 * Create by archerda on 2017/11/05.
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Clams createClams();
}
