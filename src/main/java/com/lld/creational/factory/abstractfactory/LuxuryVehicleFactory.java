package com.lld.creational.factory.abstractfactory;

import com.lld.creational.factory.abstractfactory.vehicle.*;

public class LuxuryVehicleFactory implements AbstractFactory {
    private static LuxuryVehicleFactory instance=new LuxuryVehicleFactory();
    private LuxuryVehicleFactory(){

    }

    public static LuxuryVehicleFactory getInstance()
    {
        return  instance;
    }
    @Override
    public Vehicle getVehicle(String name) {
        if (name.equalsIgnoreCase("LuxuryVehicle1")) {
            return new LuxuryVehicle1();
        } else if (name.equalsIgnoreCase("LuxuryVehicle2")) {
            return new LuxuryVehicle2();
        } else {
            return null;
        }
    }
}
