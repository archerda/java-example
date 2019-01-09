package com.github.archerda.designpattern.decorator;

/**
 * 抽象装饰者；
 *
 * 调料类；
 *
 * 必须让 CondimentDecorator 能够取代 Beverage, 所以将 CondimentDecorator 继承自 Beverage;
 *
 * Create by archerda on 2017/08/24.
 */
public abstract class CondimentDecorator extends Beverage {

    // 所有的调料者都必须重新实现 getDescription；
    // TODO by archerda on 24/08/2017. why？
    public abstract String getDescription();
}
