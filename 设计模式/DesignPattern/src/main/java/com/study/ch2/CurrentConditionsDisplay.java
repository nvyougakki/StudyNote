package com.study.ch2;

import lombok.Data;

/**
 * @Author heyu
 * @Date 2021/4/14 17:31
 * @Package com.study.ch2
 * @Description
 **/
@Data
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Subject weatherData;

    private float temperature;

    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
