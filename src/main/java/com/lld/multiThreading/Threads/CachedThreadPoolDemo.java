package com.lld.multiThreading.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolDemo {
    static long minSleepTime = 5000; // 3 second
    static long maxSleepTime = 10000; // 6 seconds

        public static void main(String[] args) throws InterruptedException {
            // Create a cached thread pool
            //task queue can contain one task at max if all thread busy then new thread is created and task assigned to thread
            //if a thread is idle for more than 60 s it will be killed.it auto scale
            ExecutorService executor = Executors.newCachedThreadPool();




            // Simulate a large number of tasks
            for (int i = 0; i < 40; i++) {
                Runnable task = new Task(i);

                Thread.sleep(3000);
                executor.execute(task);
            }

            // Shutdown the executor
            executor.shutdown();

            // Wait for all tasks to complete
            try {
                executor.awaitTermination(60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        static class Task implements Runnable {
            private int taskId;

            public Task(int taskId) {
                this.taskId = taskId;
            }

            @Override
            public void run() {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
                try {
                    // Simulate some work
                    long randomSleepTime = minSleepTime + (long)(Math.random() * (maxSleepTime - minSleepTime + taskId*1000));

                    Thread.sleep(randomSleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed.");
            }
        }
    }


