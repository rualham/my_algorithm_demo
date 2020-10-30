package com.ham.my_algorithm;

public class MaxOfNDigits {
    public static void main(String[] args) {
//        printToMaxOfNDigits_1(-5);
//        printToMaxOfNDigits_1(5);
//        printToMaxOfNDigits_3(5);
        printToMaxOfNDigits_2(5);
    }


    public static void printToMaxOfNDigits_1(int n) {
     /*   long number = 1;
        int i = 0;
        while (i < n) { //利用while循环计算出比n位十进制多1的数
            number *= 10;
            ++i;
        }
        for (long j = 1; j < number; j++) { //利用for循环输出从1到最大的n位数
            System.out.print(j + " ");
//            if (j % 5 == 0) {
//                System.out.println();
//            }
        }*/

        if (n <= 0) {
            System.out.println("输入的n没有意义");
            return;
        }
        //声明字符数组，用来存放一个大数
        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {//对字符0进行初始化
            number[i] = '0';
//            int a = number[i];
//            System.out.println("number[i]  = " + number[i] +"  a:"+ a);
        }

        while (!incrementNumber(number)) {//如果大数自加，直到自溢退出
            printNumber(number);
        }
        System.out.println("number = " + number);
    }

    private static boolean incrementNumber(char[] number) {
        boolean isOverflow = false;//判断是否溢出
        int nTakeOver = 0;//判断是否进位
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; --i) {
            int nSum = number[i] - '0' + nTakeOver;//取到第i位的字符转换为数字+进位符
            if (i == nLength - 1) { //末尾自加1
                ++nSum;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;

    }

    //打印1到最大的n位数的主方法
    public static void printToMaxOfNDigits_3(int n) {
        if (n <= 0) {
            System.out.println("输入的n没有意义");
            return;
        }
        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    //利用递归实现1到最大的n位数的全排列
    public static void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if (index == n - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }


    //打印数字
    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void printToMaxOfNDigits_2(int n) {
        int[] array = new int[n];
        if (n <= 0) {
            return;
        }
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if (n != array.length) {
                array[n] = i;
                printArray(array, n + 1);
            } else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if (isFirstNo0) {
                            System.out.print(array[j]);
                        }
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}
