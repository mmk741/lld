package com.lld.creational.factory.abstractfactory;

public class VehicleFactoryFactory {

    public static AbstractFactory getFactory(String name)
    {
        if(name.equalsIgnoreCase("Luxury"))
            return  LuxuryVehicleFactory.getInstance();
        else if(name.equalsIgnoreCase("ordinary"))
            return  OrdinaryVehicleFactory.getInstance();
        else return null;
    }
}
