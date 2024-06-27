package com.lld.practice;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WeatherObservable weatherObservable=new WeatherObservable();
        WeatherDisplayObserver weatherDisplayObserver=new WeatherDisplayObserver(weatherObservable);
        weatherObservable.setTemperature(43);
        weatherObservable.setTemperature(30);
    }
}

interface Observable{

    void addObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObserver();
    int getData();
}

class WeatherObservable implements  Observable{
List<Observer> observerList=new ArrayList<>();
private int temperature;
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer:observerList){
            observer.update();
        }
    }

    public int getData() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObserver();
    }
}

interface Observer{

    void update();

}

class WeatherDisplayObserver implements Observer{

    Observable observable;

    WeatherDisplayObserver(WeatherObservable weatherObservable){
        observable=weatherObservable;
        observable.addObserver(this);
    }
    @Override
    public void update() {
        System.out.println("temperature is changed to:"+observable.getData());

    }
}




