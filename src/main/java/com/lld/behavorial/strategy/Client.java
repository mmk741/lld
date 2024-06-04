package com.lld.behavorial.strategy;

public class Client {
    public static void main(String[] args) {
        FlyingMachine aerObj=new Aeroplane();
        aerObj.fly();
    }
}
