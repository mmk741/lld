package com.lld.multiThreading;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreeThreadPrintAlternate {

    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
//        Thread t1=new Thread(new Printer(lock,10,1),"Thread1");
//        Thread t2=new Thread(new Printer(lock,10,2) ,"Thread2");
//        Thread t3=new Thread(new Printer(lock,10,0),"Thread3");
//
//        t1.start();
//        t2.start();
//        t3.start();

        //use executorService.shutdown(); to terminate code else code will keep running
        //Executor service
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Printer(lock,10,1));
        executorService.submit(new Printer(lock,10,2));
        executorService.submit(new Printer(lock,10,0));


    }
}


class Printer implements Runnable {

    private static int count=1;
    private int maxLimit;

    private int rem;
    private final Object lock;
    Printer(Object lock , int maxLimit , int rem){
        this.lock=lock;
        this.maxLimit=maxLimit;
        this.rem=rem;

    }
    @Override
    public void run() {

        synchronized (lock){
            while(count<=maxLimit)
            {
                while(count%3!=rem)
                {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+"  "+count);
                count++;
                lock.notifyAll();
            }

        }

    }
}
