package com.lld.creational.singelton;

public class Singelton {
    public static void main(String[] args) {
        SynchronizedMethodSingelton obj=SynchronizedMethodSingelton.getInstance();
    }
}

 class EagerSingelton {
    private static EagerSingelton instance=new EagerSingelton();
    private EagerSingelton(){

    }

    public static EagerSingelton getInstance(){
        return instance;
    }
}

class LazySingelton {
    private static LazySingelton instance;
    private LazySingelton(){

    }

    public static LazySingelton getInstance(){
       if(instance==null)
       {
           instance=new LazySingelton();
       }

        return instance;
    }
}

class SynchronizedMethodSingelton {
    private static SynchronizedMethodSingelton instance;
    private SynchronizedMethodSingelton(){

    }

   synchronized public static SynchronizedMethodSingelton getInstance(){
        if(instance==null)
        {
            instance=new SynchronizedMethodSingelton();
        }

        return instance;
    }
}

class DoubleLockingSingelton {

    //volatile is used here as while  craeating it directly write into memory and not cache of cores of cpu as each core has its cache
    private static volatile DoubleLockingSingelton instance;
    private DoubleLockingSingelton(){

    }

     public static DoubleLockingSingelton getInstance(){
        // synchronized (this) is not used as this refers to instance of class and here object is class level that is static
        if(instance==null) {
            synchronized (DoubleLockingSingelton.class) {
                if (instance == null) {
                    instance = new DoubleLockingSingelton();
                }
            }
        }

        return instance;
    }
}

class PrivateStaticInnerClassSingelton {

    //drawback of eager initilaization was that it create object at runtime even we dont need this
    //it is solved here by making private static inner class as by doing this above will not happen


    private PrivateStaticInnerClassSingelton(){

    }

//    inner class is not loaded until it's actually needed. This ensures lazy initialization, meaning the instance of the Singleton is only created when it is first accessed.
    private  static class Helper{
        private static  PrivateStaticInnerClassSingelton instance=new PrivateStaticInnerClassSingelton();
    }

    public static PrivateStaticInnerClassSingelton getInstance(){


        return Helper.instance;
    }
}