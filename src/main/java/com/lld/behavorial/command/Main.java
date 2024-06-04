package com.lld.behavorial.command;

public class Main {

    public static void main(String[] args) {
        AirConditioner ac=new AirConditioner();
        MyRemoteControl remoteObj=new MyRemoteControl();

        remoteObj.setCommand(new TurnOnAcCommand(ac));
        remoteObj.pressButton();
        remoteObj.undo();
    }




}
