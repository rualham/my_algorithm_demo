package com.ham.my_algorithm;

public class MySort {
    //    最小的K个数
    public static void main(String[] args) {
        int arr[] = new int[]{8, 7, 9, 6, 2, 1, 5, 4};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("a[i] = " + arr[i]);
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("quickSort a[i] = " + arr[i]);
        }
    }

    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i != j) {
            //先从右边开始往左找，直到找到比pivot值小的数
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            //先从左边开始往左找，直到找到比pivot值大的数
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            // 找到左边比中轴大，右边比中轴小的数，交换两个数在数组中的位置
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        arr[left] = arr[i];
        arr[i] = pivot;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}