package com.github.archerda.designpattern.observer.buintin;

import java.util.Observable;

/**
 * Create by archerda on 2017/08/09.
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        // 注意，我们没有调用notifyObservers传送数据，这表示我们采用的是pull的模式；
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // 下面这3个getter并不是新方法，只是因为我们用 pull 的做法，观察者会利用这些方法取得 WeatherData 的状态；
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
