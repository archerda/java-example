package com.github.archerda.designpattern.factory.factorymethod;

import com.github.archerda.designpattern.factory.Pizza;



/**
 * Create by archerda on 2017/10/31.
 */
public class Main {

    public static void main(String[] args) {

        // 创建一个纽约风格的披萨店；
        PizzaStore nyStylePizzaStore = new NYStylePizzaStore();
        Pizza nyStylePizza = nyStylePizzaStore.orderPizza("cheese");
        System.out.println(nyStylePizza);

        // 创建一个芝加哥风格的披萨店；
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println(chicagoPizza);

    }
}
