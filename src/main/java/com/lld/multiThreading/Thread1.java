package com.lld.multiThreading;

public class Thread1 extends Thread{

    //to give name to thread
    public Thread1(String threadName) {
        super(threadName);
    }

    //whatever code we write inside this are run by this thread similar whatever we write in main are run by main thread
    @Override
    public void run(){

        for (int i=0;i<5;i++)
        {
            System.out.println("In thread 1:"+Thread.currentThread().getName()+" " +i);
        }

    }
}
