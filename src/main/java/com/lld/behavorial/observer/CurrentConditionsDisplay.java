package com.lld.behavorial.observer;

public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Observable weatherData; //if any data this class need from weatherData it can take thas why we keep it here also it tells observable to add himself

    public CurrentConditionsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
