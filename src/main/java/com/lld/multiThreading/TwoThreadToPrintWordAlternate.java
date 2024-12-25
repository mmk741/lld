package com.lld.multiThreading;


/*
*   1. common lock
*   2. thread identification ie threadNumber
*   3. static current Running thread as all thread chang is common to all
*
* */
public class TwoThreadToPrintWordAlternate {

    public static void main(String[] args) {

        Object lock=new Object();
        Thread t1 = new Thread(new AlternatePrinter("game", 0, lock));
        Thread t2 = new Thread(new AlternatePrinter("play", 1, lock));

        t1.start();
        t2.start();
    }
}

class AlternatePrinter implements Runnable{
private String word;
private static  int crt=0; //this should be static as it will be common for all thread
private int thNo;
private Object lock;

AlternatePrinter(String word , int thNo,Object lock)
{
    this.word=word;
    this.thNo=thNo;
    this.lock=lock;
}
    @Override
    public void run() {

    for(int i=0;i<=10;i++)

        synchronized (lock) {
            while(crt!=thNo)
            {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
          System.out.print(word + " ");
            crt=1-crt;
          lock.notifyAll();
      }
    }
}