package com.lld.multiThreading;

public class FourThreadToPrintAlternate {
    public static void main(String[] args) {


        Object lock = new Object();
        Thread t1 = new Thread(new Printers(1, lock));
        Thread t2 = new Thread(new Printers(2, lock));
        Thread t3 = new Thread(new Printers(3, lock));
        Thread t4 = new Thread(new Printers(4, lock));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}


class Printers implements Runnable {
    private static int number = 1;
    private static int ceth = 1;
    private int thNo;

    private Object lock;

    Printers(int thNo, Object lock) {
        this.thNo = thNo;
        this.lock = lock;

    }

    @Override
    public void run() {
        synchronized (lock) {
        while (number <= 10) {

                while (thNo != ceth) {
                    try {
                        lock.wait();//or wait() both we do same

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName() + "  " + number++);
                ceth++;
                if (ceth > 4)
                    ceth = 1;

                lock.notifyAll();
            }
        }
    }
}
