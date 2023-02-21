package com.vickllny.leetcode;

public class FinalTest {
    private int a;
    private final int b;

    static FinalTest finalTest;

    public FinalTest(){
        a = 1;
        b = 2;
    }

    public static void write(){
        finalTest = new FinalTest();
    }

    public static void read(){
        FinalTest test = finalTest;
        int a = test.a;
        int b = test.b;
        if(a == 0){
            System.out.println("发生了重排序");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(;;){
                FinalTest.write();
            }
        });
        Thread t2 = new Thread(() -> {
            for(;;){
                FinalTest.read();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
