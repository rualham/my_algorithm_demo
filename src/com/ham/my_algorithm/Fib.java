package com.ham.my_algorithm;

public class Fib {

    public static void main(String[] args) {

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
}
