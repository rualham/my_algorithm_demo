package com.ham.my_algorithm;


/*java给定一个数组，求是否存在数组里的两个元素相加等于目标数并求出下标*/

import java.lang.reflect.Array;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 9, 6, 3, 5, 4, 7, 2, 5, 4, 8, 9, 6, 3, 2, 1, 8};
        int[] arr1 = new int[]{2, 8, 6, 7, 5, 4, 9, 3, 1};
        //0,1,2,3,4,5,6,7,8,9
//        twosum(arr, 20);
//        returnnum(arr, 10);
//        returnnum1(arr, 10);
//        System.out.println("  = " +returnnum1(arr, 20)  );
        System.out.println("  = " + hashsum(arr1, 10));
//        System.out.println("  = " + calculatTwoSumAll(arr1, 10));
    }

    public static void twosum(int arr[], int target) {
        boolean hasTarget = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    hasTarget = true;
                    System.out.println(arr[i] + "+ " + arr[j] + "= " + target);
                    System.out.println("下标的值分别为:i=" + i + "和" + "j = " + j);
                } else {

                }
            }
        }
        if (!hasTarget) {
            System.out.println("未找到下标的值");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers为空！");
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int otherNumber = target - numbers[i];
            if (resultMap.get(otherNumber) != null) {
                return new int[]{i, resultMap.get(otherNumber)};
            } else {
                resultMap.put(numbers[i], i);
            }
        }
        throw new IllegalArgumentException("numbers为空！");
    }

    //二分查找，先排序，然后依次比较
    public static void returnnum(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        int low = 0;
        int heigh = arr.length - 1;
        while (low < heigh) {
            if (arr[low] + arr[heigh] < target) {
                low++;
            } else if (arr[low] + arr[heigh] > target) {
                heigh--;
            }
            if (arr[low] + arr[heigh] == target) {
                System.out.println(arr[low] + "+" + arr[heigh] + "=" + target);
                System.out.println("第一个下标为：" + low + "第二个下标为：" + heigh);
                heigh--;
            }
        }
    }

    public static int returnnum1(int arr[], int target) {
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        int left = 0;
        int right = arr.length - 1;
        while (left != right) {
            if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
            if (arr[left] + arr[right] == target) {
                System.out.println(arr[left] + "+" + arr[right] + "=" + target);
                System.out.println("第一个下标为：" + left + "第二个下标为：" + right);
            }
        }
        return target;
    }

    public static int[] hashsum(int arr[], int target) {
        int temp[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int other = target - arr[i];
            if (map.containsKey(other)) {
                temp[0] = i;
                temp[1] = map.get(other);
                break;
            }
        }
        return temp;
    }

    public static List<int[]> calculatTwoSumAll(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers为空！");
        }
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < numbers.length; i++) {
            int otherNumber = target - numbers[i];
            if (resultMap.get(otherNumber) != null) {
                flag = true;
                result.add(new int[]{i, resultMap.get(otherNumber)});
            } else {
                resultMap.put(numbers[i], i);
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("numbers为空！");
        }
//        System.out.println("arr = " + Arrays.toString(result));
        return result;
    }
}
