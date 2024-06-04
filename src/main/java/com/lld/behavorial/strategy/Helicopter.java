package com.lld.behavorial.strategy;

public class Helicopter extends FlyingMachine{
    Helicopter() {
        super(new NoRunWayStrategy());
    }
}
