package com.github.archerda.designpattern.factory;

/**
 * 披萨抽象类
 *
 * Create by archerda on 2017/10/17.
 */
public interface Pizza {

    void prepare();

    void bake();

    void cut();

    void box();

}
