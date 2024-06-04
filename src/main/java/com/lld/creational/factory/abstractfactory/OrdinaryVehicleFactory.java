package com.lld.creational.factory.abstractfactory;

import com.lld.creational.factory.abstractfactory.vehicle.OrdinaryVehicle1;
import com.lld.creational.factory.abstractfactory.vehicle.OrdinaryVehicle2;
import com.lld.creational.factory.abstractfactory.vehicle.Vehicle;

public class OrdinaryVehicleFactory implements AbstractFactory {

    private static OrdinaryVehicleFactory instance=new OrdinaryVehicleFactory();
    private OrdinaryVehicleFactory(){

    }

    static OrdinaryVehicleFactory getInstance()
    {
        return  instance;
    }
    @Override
    public Vehicle getVehicle(String name) {
        if (name.equalsIgnoreCase("OrdinaryVehicle1")) {
            return new OrdinaryVehicle1();
        } else if (name.equalsIgnoreCase("OrdinaryVehicle2")) {
            return new OrdinaryVehicle2();
        } else {
            return null;
        }
    }
}
