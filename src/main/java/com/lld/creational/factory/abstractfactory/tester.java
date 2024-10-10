package com.lld.creational.factory.abstractfactory;

import com.lld.creational.factory.abstractfactory.vehicle.Vehicle;

public class tester {
    public static void main(String[] args) {
        AbstractFactory luxury = VehicleFactoryFactory.getFactory("Luxury");
        Vehicle luxuryVehicle1 = luxury.getVehicle("LuxuryVehicle1");
        luxuryVehicle1.getDetails();
    }
}
