package com.ham.my_algorithm;

import java.util.HashMap;
import java.util.Map;

public class NotRepeatingChar {
    /* 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
     Input: abacc
     Output: b
             解题思路
     最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap，从而将空间复杂度由 O(N) 降低为 O(1)。*/
    public static void main(String[] args) {
        int a = firstNotRepeatingChar("abacc");
        System.out.println("a = " + a);
        int b = firstNotRepeatingChar1("abacc");
        System.out.println("b = " + b);
    }

    private static int firstNotRepeatingChar1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                value++;
                map.put(str.charAt(i), value);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                return character;
            }
        }
        return 0;
    }

    public static int firstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }
}
