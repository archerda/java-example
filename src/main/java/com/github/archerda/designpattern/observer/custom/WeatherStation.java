package com.github.archerda.designpattern.observer.custom;

/**
 * 气象站；
 * Create by archerda on 2017/08/09.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
