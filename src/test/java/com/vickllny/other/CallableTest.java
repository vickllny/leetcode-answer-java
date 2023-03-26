package com.vickllny.other;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println("callable execute ...");
            return 1024;
        });
        Thread t1 = new Thread(task, "ccc");
        t1.start();
        Integer result = task.get();
        System.out.println(result);
    }

}
