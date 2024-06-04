package com.lld.creational.factory.abstractfactory;

import com.lld.creational.factory.abstractfactory.vehicle.Vehicle;

public interface AbstractFactory {

    Vehicle getVehicle(String name);

}
