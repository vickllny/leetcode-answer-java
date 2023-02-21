package com.vickllny.leetcode;

public class TestClass {

    private static TestClass myTestClass = new TestClass();

    private static int a = 0;
    private static int b;

    private TestClass() {
        a++;
        b++;
    }

    public static TestClass getInstance() {
        return myTestClass;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public static void main(String[] args) {
        TestClass myTestClass = TestClass.getInstance();
        System.out.println("myTestClass.a : " + myTestClass.getA());
        System.out.println("myTestClass.b : " + myTestClass.getB());

    }
}
