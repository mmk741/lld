package com.lld.behavorial.observer;

import java.util.List;

//Observale or ObserverRegistry
public interface Observable {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
