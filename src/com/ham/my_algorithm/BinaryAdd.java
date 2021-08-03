package com.ham.my_algorithm;

public class BinaryAdd {

    //二进制中1的个数

    public static void main(String[] args) {

        numberOf1(0x100);
    }

    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & n - 1;
        }
        return count;
    }
}
