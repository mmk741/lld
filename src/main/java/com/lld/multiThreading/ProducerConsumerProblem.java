package com.lld.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer=new ProducerConsumer(5);

        //creating producer to produce item to queue
        Thread producert1=new Thread(()->{
            for(int i=0;i<10;i++){
                int x= 0;
                try {
                    x = producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(x);
            }
        });
        Thread producert2=new Thread(()->{
            for(int i=0;i<10;i++){
                int x= 0;
                try {
                    x = producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(x);
            }
        });
        //creating consumer to consume item from queue
        Thread consumert2=new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    producerConsumer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread consumert3=new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    producerConsumer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread consumert4=new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    producerConsumer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        consumert2.start();
        producert1.start();
        producert2.start();
        consumert3.start();
        consumert4.start();

    }

}



class ProducerConsumer {
    private Queue<Integer> queue;
    private int capacity;

    ProducerConsumer(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }


    synchronized int consume() throws InterruptedException {
        if (queue.size() == 0) {
            System.out.println("consumer waiting for producer to produce since queue is empty");
            //wait when queue size is 0
            wait();
        }
        int x = queue.poll();
        //notify the producer there is space in queue now
        notify();

        return x;

    }

    //here lock is applied on "this" i.e object of this class
    synchronized void produce(int x) throws InterruptedException {

        //while is use instead of "if" as let say queue is full and a consumer consumes one item and here in producer 5
        //thread is waiting then when consumer will call notify all will ne awoked and first will produce bit other will led to out of space
        while (queue.size() == capacity) {
            System.out.println("producer  waiting for  consumer since queue is full ");
            wait();
        }

        queue.offer(x);
        //notify consumer that item is added
        notify();

    }
}

