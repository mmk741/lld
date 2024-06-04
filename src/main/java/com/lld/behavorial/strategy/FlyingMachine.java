package com.lld.behavorial.strategy;

public abstract class FlyingMachine {
    private final FlyingStrategy flyingStrategyObj;



    FlyingMachine(FlyingStrategy flyingStrategyObj) {
        this.flyingStrategyObj = flyingStrategyObj;
    }

   protected void fly(){
        flyingStrategyObj.wayToFly();
    }

}
