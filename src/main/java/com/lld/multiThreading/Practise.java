package com.lld.multiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Practise {
    public static void main(String[] args) {
        Object lock=new Object();

        ExecutorService executorService=Executors.newFixedThreadPool(5);
        executorService.submit(new ThreadPrinter(lock,1));
        executorService.submit(new ThreadPrinter(lock,2));
        executorService.submit(new ThreadPrinter(lock,3));
        executorService.submit(new ThreadPrinter(lock,4));
        executorService.submit(new ThreadPrinter(lock,5));

        executorService.shutdown();

    }


}

class ThreadPrinter implements Runnable{

    private Object lock;
    private static int crt=1;
    private int thNo;

    private static int counter=1;

    ThreadPrinter(Object lock , int thNo)
    {
        this.lock=lock;
        this.thNo=thNo;
    }


    @Override
    public void run() {

       while(counter<=10)
       {
           synchronized (lock){
               while(crt!=thNo)
               {
                   try {
                       lock.wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }

                if(counter<=10)
               System.out.println(Thread.currentThread().getName()+"  "+ counter++);
               crt++;
               if(crt>5)
                   crt=1;
               lock.notifyAll();
           }
       }
    }
}



