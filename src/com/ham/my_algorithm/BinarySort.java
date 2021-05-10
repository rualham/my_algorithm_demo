package com.ham.my_algorithm;

import java.util.Arrays;

public class BinarySort {
    //二分法查找
    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(myBinarySearch(arr, 40));
    }

    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int heigh = arr.length - 1;
        while (low < heigh) {
            int mid = (low + heigh);
            if (value == arr[mid]) return mid;
            if (value > arr[mid]) low = mid + 1;
            if (value < arr[mid]) heigh = mid - 1;

        }
        return -1;
    }
}
