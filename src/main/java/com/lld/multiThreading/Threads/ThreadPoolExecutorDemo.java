package com.lld.multiThreading.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with a fixed pool size of 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks for execution
        /*
        *    difference between the submit() and execute() methods in the ExecutorService lies
        *     in their return types and how they handle exceptions
        *
        *       submit()  -> return future object , use for callable task , exception is captured in future
        *       execute   -> return void   , fire and forget task callable task , through exception
        *
        * */
        for (int i = 1; i <= 100  ; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor when tasks are done if shutdown is not done code will not stop
       executor.shutdown();
    }
}
