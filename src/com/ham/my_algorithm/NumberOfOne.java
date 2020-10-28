package com.ham.my_algorithm;

public class NumberOfOne {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        int num = NumberOf1(7);
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println(num);
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    private static int NumberOf1(int i) {
        return Integer.bitCount(i);
    }
}
