package com.lld.multiThreading;

public class ThreadTester {
    public static void main(String[] args) {

        //Thread creation by extending thread class
//        Thread1 thread1=new Thread1("myThreadCustomName");
////        thread1.setDaemon(true);
//        System.out.println("main is executing");
//        //it does not start thread immediatly its on JVM when it start it will call run method
//        thread1.start();
//        System.out.println("main ended");

        //***********************************************
        //Thread creation by implementing runnable interface (functional interface)
//        Thread2 thread2=new Thread2();
//        Thread thread=new Thread(thread2);
//        System.out.println("main is executing");
//        //it does not start thread immediatly its on JVM when it start it will call run method
//        thread.start();
//        System.out.println("main ended");

        //*******************************************************
        //another way by lambda as runnable is functional interface

        Thread thread3 =new Thread(()->{
            for (int i=0;i<5;i++)
            {
                System.out.println("In thread 3:"+Thread.currentThread().getName()+" " +i);
            }
        },"thread3Name");
        thread3.start();

    }
}
