package com.github.archerda.designpattern.factory.abstractfactory;

import com.github.archerda.designpattern.factory.abstractfactory.ingredient.Clams;
import com.github.archerda.designpattern.factory.abstractfactory.ingredient.Dough;
import com.github.archerda.designpattern.factory.abstractfactory.ingredient.Sauce;

/**
 * Create by archerda on 2017/11/05.
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", clams=" + clams +
                '}';
    }
}
