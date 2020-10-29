package com.ham.my_algorithm;

public class MyMinInReversingList {

    // 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为旋转。
    // 输入一个递增的排序的数组的一个旋转，输出旋转数组的最小元素。
    public static void main(String[] args) {
//        int[] a = {3, 4, 5, 6, 7, 1, 2,};
        int[] b = {3, 4, 5, 6, 1, 2};
//        int[] c = {6, 1, 2, 3, 4, 5};
        int[] d = {1, 0, 1, 1, 1};
//        minInReversingList_1(a);
//        System.out.println("a = " + minInReversingList_1(a));
        System.out.println("b = " + minInReversingList_1(b));
        System.out.println("d = " + minInReversingList_1(d));
    }

    public static int minInReversingList_1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1 || array[array.length - 1] > array[0]) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }
            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int minInReversingList_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
