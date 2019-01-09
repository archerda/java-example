package com.github.archerda.designpattern.decorator;

/**
 * Create by archerda on 2017/08/24.
 */
public class Main {

    public static void main(String[] args) {
        // 订一杯 Coffee，不需要调料；
        Beverage beverage1 = new Coffee();
        System.out.println(beverage1.getDescription() + " ￥" + beverage1.cost());

        // 制造一个 Tea 对象；
        Beverage beverage2 = new Tea();
        beverage2 = new Mocha(beverage2); // 用 Mocha 装饰它；
        beverage2 = new Mocha(beverage2); // 用第二个 Mocha 装饰它；
        beverage2 = new Milk(beverage2); // 用 Milk 装饰它；
        System.out.println(beverage2.getDescription() + " ￥" + beverage2.cost());
    }
}
