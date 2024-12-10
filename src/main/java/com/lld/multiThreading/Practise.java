package com.lld.multiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Practise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       Object lock=new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Print("fizz",0,lock));
        executorService.submit(new Print("buzz",1,lock));

        executorService.shutdown();
        System.out.println("hello world");


    }
}


class Print implements Runnable{
private String word;
private static int crt=0;
private int thId;
private Object lock;

    public Print(String word, int thId,Object lock) {
        this.word = word;
        this.thId = thId;
        this.lock=lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
        for(int i=0;i<=10;i++){

            while (crt != thId) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName()+" "+word);
            crt=1-crt;

            lock.notifyAll();
        }
    }
    }
}
