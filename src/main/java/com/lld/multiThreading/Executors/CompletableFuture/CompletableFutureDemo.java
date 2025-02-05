package com.lld.multiThreading.Executors.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

//FutureDemo
//Executor submit function return Future
//        get
//         isDone
//        isCancelled
//
//CompletableFuture (by default fork join pool is used )
//supplyAsync(Supplier<T>) supplyAsync(Supplier<T>,Executor)  // returns CompletableFuture
//CompletableFuture<Void> thenRun(Runnable action)  //this tun when CompletableFuture finish success or exception
//thenApply(same thread is used which done prev oprn), thenApplyAsync(diff thread is used order not guarantee fork join pool)    //apply transformation to previous result ..oprn on prev Async oprn and return
//thenCompose thenComposeAsync  //if curr task is dependen of prev task res ...when function returs a completableFuture the we use compose as it will fllaten the completableFuture
//thenAccept thenAcceptAsync //end stage of chain of async oprn return nothing ..main thread wont wait for this
//        then combine , thenCombineAsync //combine result of 2 completable future
//allOf // CompletableFuture.allOf(future1, future, future2, future3, combinedFuture).join();
        // It takes an array or varargs of CompletableFuture instances and returns a new CompletableFuture<Void>.
        //it is completed when all of the future inside it are completed
//        exceptionally  //to handle exception



public class CompletableFutureDemo {
    public static void main(String[] args) {

        // supplyAsync
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running computation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        // Use the result of the CompletableFuture and return nothing
        future1.thenAccept(result -> System.out.println("Result: " + result));

        //we use runAsync when result is void else we use supplyAsync
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            //Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed");
        });

        //it run when completableFuture is finished either success or with exception
        future.thenRun(() -> System.out.println("Callback after task completion"));


        // thenApply
        CompletableFuture<Integer> future2 = future1.thenApply(result ->  20 * result);
        //join() is use to block and wait for completion of completable future
        System.out.println("future 2: " +future2.join());


        // thenCompose
        CompletableFuture<Integer> future3 = future1.thenCompose(result -> {
            // Simulate another asynchronous operation dependent on the result of stage1
            System.out.println("Stage 2 is running with result from stage 1: " + result);
            return CompletableFuture.supplyAsync(() -> result * 5);
        });

        System.out.println("Future 3 "+future3.join());


//
//        // thenCombine
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> combinedFuture = future4.thenCombine(future5, (result1, result2) -> result1 + result2);



        CompletableFuture.allOf(future1, future, future2, future3, combinedFuture).join();

        System.out.println("combined future -"+combinedFuture.join());


        // exceptionally
        CompletableFuture<Object> future6 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Exception occurred");
        }).exceptionally(exception -> {
            System.out.println("Exception occurred: " + exception.getMessage());
            return 0;
        });

//
//        // allOf
//        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> 10);
//        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> 20);
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future7, future8);
//
//        // thenRun
//        allFutures.thenRun(() -> System.out.println("All futures completed"));
//
//        // Join all futures to wait for their completion
//        CompletableFuture.allOf(future1, future2, future3, future4, future5, future6, future7, future8).join();
//
//        CompletableFuture<String> future9 = new CompletableFuture<>();
//
//        // Complete the future with a value after a delay
//        CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS)
//                .execute(() -> future9.complete("Result"));
//
//        // Complete the future with a default value if it hasn't been completed before the timeout
//        future9.completeOnTimeout("Default", 1, TimeUnit.SECONDS);
//
//        // Wait for the future to complete and print the result
//        try {
//            String result = future9.get();
//            System.out.println("Result: " + result);
//        } catch (Exception e) {
//            System.out.println("Exception: " + e);
//        }
//
//        CompletableFuture<Integer> future10 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println("Task was interrupted.");
//            }
//            return 42;
//        });
//
//        boolean cancelled = future10.cancel(true);
//        System.out.println("Task cancelled: " + cancelled);


        // Exception Handling
        // Issue: Limited Exception Handling

        // Multiple futures cannot be combined/chained together
        // Issue: Inability to Combine Futures
        // - Future doesn't provide a straightforward way to combine or chain multiple futures together,
        // making it difficult to handle dependencies between tasks.
        /*
        Future<String> future1 = executor.submit(() -> readFile("file1.txt"));
        Future<String> future2 = executor.submit(() -> readFile("file2.txt"));

        future1.future2.get();
        */
    }
    
}
