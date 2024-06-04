package com.lld.behavorial.strategy;

public class Aeroplane extends FlyingMachine{
    Aeroplane() {
        super(new NeedRunWayStrategy());
    }
}
