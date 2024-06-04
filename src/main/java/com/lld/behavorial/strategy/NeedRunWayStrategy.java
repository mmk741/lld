package com.lld.behavorial.strategy;

public class NeedRunWayStrategy extends FlyingStrategy{
    @Override
    public void wayToFly() {
        System.out.println(" Runway required");
    }
}
