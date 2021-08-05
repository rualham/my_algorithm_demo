package com.ham.my_algorithm;

public class MySort {
    //    最小的K个数
    public static void main(String[] args) {
        int arr[] = new int[]{8, 7, 9, 6, 2, 1, 5, 4};
    /*    sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("a[i] = " + arr[i]);
        }*/
//        quickSort(arr, 0, arr.length - 1);
//            System.out.println("a[i] = " + arr[i]);
//        }
//        quickSort(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("quickSort a[i] = " + arr[i]);
//        }
//        sort(arr);
//        insertionSort(arr);
        insertionSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("quickSort a[i] = " + arr[i]);
        }
    }

    //冒泡排序
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


    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort1(int[] array) {
        int len;
        // 基本情况下的数组可以直接返回
        if (array == null || (len = array.length) == 0 || len == 1) {
            return array;
        }
        int current = 0;
        int preIndex = 0;

        for (int i = 0; i < array.length-1; i++) {
            current = array[i + 1];
            preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }


    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        int len;
        // 基本情况下的数组可以直接返回
        if (array == null || (len = array.length) == 0 || len == 1) {
            return array;
        }
        int current;
        for (int i = 0; i < len - 1; i++) {
            // 第一个数默认已排序，从第二个数开始
            current = array[i + 1];
            // 前一个数的下标
            int preIdx = i;

            // 拿当前的数与之前已排序序列逐一往前比较，
            // 如果比较的数据比当前的大，就把该数往后挪一步
            while (preIdx >= 0 && current < array[preIdx]) {
                array[preIdx + 1] = array[preIdx];
                preIdx--;
            }
            // while循环跳出说明找到了位置
            array[preIdx + 1] = current;
        }
        return array;
    }
}
