package com.github.archerda.designpattern.observer.buintin;

/**
 * Create by archerda on 2017/08/09.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(81, 66, 30.5f);
    }
}
