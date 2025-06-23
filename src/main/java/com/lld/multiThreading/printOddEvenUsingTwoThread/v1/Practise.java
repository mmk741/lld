package com.lld.multiThreading.printOddEvenUsingTwoThread.v1;

//odd even printer
//below we made class for share object also you can do by taking static share data like in fizz buzz problem
public class Practise {
    public static void main(String[] args) {
        Object obj=new Object();
       SharedStae state=new SharedStae();
        Thread odd=new Thread(new PrinterPractice(State.ODD,obj,state));

        Thread even=new Thread(new PrinterPractice(State.EVEN,obj,state));

        odd.start();
        even.start();


    }
}

class PrinterPractice implements Runnable {

    private SharedStae cstate;
    private State th;
    private Object lock;
    private static int numberToPrint=1;

    PrinterPractice(State th,Object lock,SharedStae  cstate) {
        this.th=th;
        this.lock=lock;
        this.cstate=cstate;
    }


    public void run() {

        while(numberToPrint<10) {
        synchronized (lock) {
            while (!th.equals(cstate.state)) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName()+" "+numberToPrint);
            numberToPrint ++;

            cstate.state=cstate.state.equals(State.ODD)?State.EVEN:State.ODD;

            lock.notifyAll();
        }
        }
    }
}

class SharedStae{
   public State state=State.ODD;

}

enum State{
    ODD,EVEN;
}





