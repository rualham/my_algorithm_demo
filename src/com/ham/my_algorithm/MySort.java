package com.ham.my_algorithm;

public class MySort {
    //    最小的K个数
    public static void main(String[] args) {
        int arr[] = new int[]{8, 0, 12, 7, 9, 6, 2, 1, 5, 4, 11};
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
        selectSort(arr);
//        selectSortOp(arr);
//        insertionSort(arr);
//        insertionSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("quickSort a[i] = " + arr[i]);
        }
    }

    //冒泡排序
    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    //选择排序
    private static int[] selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
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

    private static int[] selectSortOp(int[] arr) {
        //选择排序的优化
        for (int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {// 选最小的记录
                if (arr[j] < arr[k]) {
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }

//    8,7,9,6,2,1,5,4
//            7,8,9,6,2,1,5,4

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
        for (int i = 0; i < array.length - 1; i++) {
            preIndex = i;
            current = array[i + 1];
//            while (preIndex >= 0 && current < array[i]) {
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
