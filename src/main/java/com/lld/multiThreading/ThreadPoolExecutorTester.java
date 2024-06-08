package com.lld.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorTester {

    public static void main(String[] args)  {

        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,5,1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),new CustomThreadFactory(), new CustomRejectedHandler());

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        //submit task ...here 25 task is executed
//        for(int i=0;i<25;i++){
//            Future<?> futureObj = threadPoolExecutor.submit(() -> {
//                try {
//                    Thread.sleep(3000);
//                    System.out.println("Thread is executing task" + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//
//            System.out.println(futureObj.isDone());
//            futureObj.cancel(false);
//        }


        //*********************************Future with Runnable and callable*********************

        //UseCase1
//        Future<?> task1_with_runnable = threadPoolExecutor.submit(() -> {
//            System.out.println("Task1 with runnable");
//        });
//
//        try {
//            Object o = task1_with_runnable.get();
//            System.out.println(o==null);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        //UseCase2 we pass list from outside and thread modifies it as Runnable do not return
//        List<Integer> output =new ArrayList<>();
//        Future<List<Integer>> task2_with_runnable = threadPoolExecutor.submit(() -> {
//            output.add(100);
//            System.out.println("Task2 with runnable and return object");
//        },output);
//
//        try {
//            List<Integer> integers = task2_with_runnable.get();
//            System.out.println(integers.get(0));
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        //UseCase3 callable return so list is created inside and returned
//        Future<List<Integer>> task3_with_callable = threadPoolExecutor.submit(() -> {
//            System.out.println("Task3 with callable");
//            List<Integer> output2 = new ArrayList<>();
//            output2.add(100);
//            return output2;
//        });
//
//
//        try {
//            List<Integer> integers = task3_with_callable.get();
//            System.out.println(integers.get(0));
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


        //***********************************************************************


        //******************************Completable future**************************

        //we provide executor to completable future if we dont provide it will use fork join pool



        try {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                return "task Completed";
            },threadPoolExecutor).thenApply((String val)->{
                return val+" successfully";
            });
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //*************************************************************************




        threadPoolExecutor.shutdown();
        System.out.println("main is ended");
    }



}

class CustomRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task denied: "+ r.toString());
    }
}
class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread =new Thread(r);
        return thread;
    }
}




