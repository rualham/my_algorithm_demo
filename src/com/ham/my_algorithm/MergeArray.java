package com.ham.my_algorithm;

public class MergeArray {
    public static void main(String[] args) {
        int[] b = {1, 2, 3, 5};
        int[] a = {2, 3, 4, 6, 7};
        mergeArr(a, b, 5, 4);
    }

    private static void mergeArr(int[] before, int[] after, int m, int n) {
        int[] newArr = new int[m + n];
        int a = 0, b = 0, count = 0;
        while (a < m && b < n) {
            if (before[a] < after[b]) {
                newArr[count++] = before[a++];
            } else {
                newArr[count++] = after[b++];
            }
        }
        if (count >= m) {
            while (b < n) {
                newArr[count++] = after[b++];
            }
        }

        if (count >= n) {
            while (a < m) {
                newArr[count++] = before[a++];
            }
        }
        System.out.println("a = " + a);
    }

  /*  public class MergeArray {
        public static void main(String[] args) {
   *//*   题目：合并两个有序数组
        给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
        说明:
        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
        示例：
        输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
        输出: [1,2,2,3,5,6]
        ————————————————
        版权声明：本文为CSDN博主「Re__CODE」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/qq_44668555/article/details/103409715*//*
            int[] nums1 = {2, 5, 6};
            int[] nums2 = {1, 2, 3, 4, 8, 9};
            merge(nums1, 3, nums2, 6);
        }

        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] newArray = new int[nums1.length + nums2.length];
            int i = 0, j = 0, count = 0;
            while (i < m && j <
                    n) {
                if (nums1[i] < nums2[j]) {
                    newArray[count++] = nums1[i++];
                } else {
                    newArray[count++] = nums2[j++];
                }
            }
            if (i >= m) {
                while (j < n) {
                    newArray[count++] = nums2[j++];
                }
            }
            if (j >= n) {
                while (i < m) {
                    newArray[count++] = nums1[i++];
                }
            }
            System.out.println("i = " + i);
        }
    }*/

}
