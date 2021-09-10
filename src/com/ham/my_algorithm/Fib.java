package com.ham.my_algorithm;

public class Fib {

    public static void main(String[] args) {


        int c = finallyTest();
        System.out.println("c = " + c);
        int a = fib(4);
        int b = fib(5);
        System.out.println("a = " + a + " b = " + b);
    }

    private static int fib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return fib(n - 1) + fib(n - 2) + fib(n - 3);
    }

    private static int finallyTest() {
        try {
//            return 0;
            throw new Exception("return");
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }
}
