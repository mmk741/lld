package com.lld.behavorial.command;

//Reciever
public class AirConditioner {
    boolean isOn;
    int temprature;

    void turnOnAc(){
        isOn=true;
        System.out.println("Ac is On");
    }

    void turnOffAc(){
        isOn=false;
        System.out.println("Ac is Off");
    }

    void setTemprature(int temprature)
    {
        this.temprature=temprature;
        System.out.println("temprature changed to :" + temprature);

    }

}
