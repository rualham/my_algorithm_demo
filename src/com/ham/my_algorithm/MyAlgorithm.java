package com.ham.my_algorithm;

public class MyAlgorithm {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        aa(3);
        System.out.println("args = " + aa(5));
    }

    public static int aa(int a) {
        if (a < 1) {
            return -1;
        } else if (a == 1) {
            return 1;
        } else {
            return 2 * aa(a - 1);
        }
    }
}
