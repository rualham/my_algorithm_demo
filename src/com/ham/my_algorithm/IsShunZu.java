package com.ham.my_algorithm;

import java.util.Arrays;

public class IsShunZu {
    //扑克牌顺子问题
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 5, 4, 0};
//        System.out.println("isShun(a) = " + isContinuous(a));
//        System.out.println("isShun(a) = " + isShun(a));
        System.out.println("a = " + sum(10));

    }

    private static int sum(int n) {
//        int sum = 1;
//        boolean flag = a == 1 ||su

        int sum = n;

        boolean flag = (sum > 0) && (sum += sum(n - 1)) > 0;
//      boolean flag = (sum > 0) && ((sum += sum(--n)) > 0);


        return sum;
    }

    private static boolean isShun(int[] a) {
        Arrays.sort(a);
        if (a.length > 5) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0) {
                continue;
            } else if (a[i + 1] == a[i]) {
                return false;
            } else {
                sum += a[i + 1] - a[i];
            }
        }
        return sum < 5;
    }

    public static boolean isContinuous(int[] numbers) {
        for (int j = 1; j < 10; j++) {
            if (j == 5) {
                continue;
            } else if (j == 5) {
                System.out.println("j ===== " + j);
            }
            System.out.println("j== = " + j);

        }
        Arrays.sort(numbers);
        int sum = 0;//***很巧妙的想法
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                continue;
            } else if (numbers[i] == numbers[i + 1]) {
                return false;
            } else {
                sum += numbers[i + 1] - numbers[i];
            }
        }
        return (sum < 5);
    }
}
