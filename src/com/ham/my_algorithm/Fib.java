package com.ham.my_algorithm;

public class Fib {

    public static void main(String[] args) {


        int c = finallyTest();
        System.out.println("c = " + c);
        int a = fib(4);
        int b = fib(5);
        System.out.println("a = " + a + " b = " + b);
        int d = addFib(5);
        System.out.println("d = " + d);
        int e = addFibThree(4);
        System.out.println("e = " + e);
    }

    private static int fib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return fib(n - 1) + fib(n - 2) + fib(n - 3);
    }

    private static int addFib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;
        int a = 1, b = 2, c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int addFibThree(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;
        if (n == 3) return 6;
        int a = 1, b = 2, c = 3, d = 6;

        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
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
