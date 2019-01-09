package com.github.archerda.designpattern.observer.custom;

import com.github.archerda.designpattern.observer.DisplayElement;

/**
 * 具体观察者实现；
 * Create by archerda on 2017/08/08.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherSubject;

    public CurrentConditionDisplay(Subject weatherSubject) {
        this.weatherSubject = weatherSubject;
        weatherSubject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
