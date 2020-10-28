package com.ham.my_algorithm;

/*10. 二进制中1 的个数
        题目描述：输入一个整数，输出该数二进制表示中1 的个数。其中负数用补码表
        示。*/

public class NumberOfOne {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
//        int num = NumberOf1_1(777777777);//程序运行时间： 24376ns
//        int num = NumberOf1_2(777777777);//程序运行时间： 2887ns
//        int num = NumberOf1_3(777777777);//程序运行时间： 2566ns
        int num = NumberOf1_4(77777777);//程序运行时间： 2246ns
//        int num = NumberOf1_5(77777777);//程序运行时间： 6736ns
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println(num);
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    private static int NumberOf1_1(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        char[] charAyyar = str.toCharArray();
        for (int i = 0; i < charAyyar.length; i++) {
            char c = charAyyar[i];
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    private static int NumberOf1_2(int n) {
        int count = 0;
        if (n < 0) {
            n = n & 0x7fffffff;
            count++;
        }
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    private static int NumberOf1_3(int n) {
        int count = 0;
        if (n < 0) {
            n = n & 0x7fffffff;
            count++;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    private static int NumberOf1_4(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }


    private static int NumberOf1_5(int i) {
        return Integer.bitCount(i);
    }
}
