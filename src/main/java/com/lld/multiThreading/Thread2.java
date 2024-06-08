package com.lld.multiThreading;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<5;i++)
        {
            System.out.println("In thread 2:"+Thread.currentThread().getName()+" " +i);
        }
    }
}
