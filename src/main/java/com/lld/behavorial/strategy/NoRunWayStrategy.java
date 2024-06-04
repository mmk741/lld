package com.lld.behavorial.strategy;

public class NoRunWayStrategy extends FlyingStrategy{
    @Override
    public void wayToFly() {
        System.out.println("No Runway required");
    }
}
