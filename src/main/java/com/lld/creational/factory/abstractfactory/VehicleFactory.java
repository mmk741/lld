package com.lld.creational.factory.abstractfactory;

public class VehicleFactory {

    public static AbstractFactory getFactory(String name)
    {
        if(name.equalsIgnoreCase("Luxury"))
            return  LuxuryVehicleFactory.getInstance();
        else if(name.equalsIgnoreCase("ordinary"))
            return  OrdinaryVehicleFactory.getInstance();
        else return null;
    }
}
