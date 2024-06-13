package com.lld.behavorial.momento;

public class Client {
    public static void main(String[] args) {
        ConfigurationCareTaker careTaker=new ConfigurationCareTaker();
        ConfigurationOrignator orignator=new ConfigurationOrignator(1,1);

        //save it
        ConfigurationMomento snapshot1=orignator.createMomento();

        //add in history
        careTaker.addMomento(snapshot1);

        orignator.setWidth(2);
        orignator.setHeight(2);
        //save it
        ConfigurationMomento snapshot2=orignator.createMomento();
        //add in history
        careTaker.addMomento(snapshot2);

        orignator.setWidth(3);

        orignator.setHeight(3);


        //Undo
        ConfigurationMomento undo = careTaker.undo();
        orignator.restoreMomento(undo);

        System.out.println("height: "+orignator.height+" width: "+orignator.width);
        System.out.println(careTaker.history.size());

    }


}
