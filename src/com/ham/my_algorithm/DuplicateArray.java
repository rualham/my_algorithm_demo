package com.ham.my_algorithm;

public class DuplicateArray {
    public static void main(String[] args) {
        //模仿hashmap 数组写法,找出数组中重复元素
        int[] a = new int[]{2, 3, 5, 1, 4, 2};
//        int[] a = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] b = new int[1];
//        System.out.println("b = " + duplicate(a, 6, b));
        System.out.println("b = " + duplicate1(a, 6, b));
//        System.out.println("b = " + duplicate(a, 7, b));
    }

    private static boolean duplicate1(int nums[], int len, int[] ans) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 || nums[i] > len - 1) {
                return false;
            }
        }

        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return true;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;


                }
            }
            int num = nums[i];

        }
        return false;
    }


    public static boolean duplicate(int nums[], int len, int[] ans) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 || nums[i] > len - 1) {
                return false;
            }
        }
        for (int i = 0; i < len; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    ans[0] = nums[i];
                    return true;
                } else {
                    int temmp = nums[i];
                    nums[i] = nums[temmp];
                    nums[temmp] = temmp;
                }
            }
        }
        return false;
    }
}