package com.ham.my_algorithm.stringdemo;

public class StringMatch {

    public static void main(String[] args) {

//        bruteForce("BBC ABCDAB ABCDABCDABDE","ABCDABD");
        kmp("BBC ABCDAB ABCDABCDABDE","ABCDABD");
    }


    //### 判等
    //
    //一对字符串S="a<sub>0</sub>a<sub>1</sub>......a<sub>n-1</sub>" 和 T="b<sub>0</sub>b<sub>1</sub>......b<sub>m-1</sub>",当且仅当二者长度相等(n=m),
    //且对应的字符分别相等(对任何0≤i 〈n,都有a<sub>i</sub> = b<sub>i</sub>)
    //
    //# 模式匹配算法
    //
    //### 朴素的模式匹配算法(BF(Brute-Force)算法)
    //
    //* 基本思想是：
    //  1. 从主串的第一个字符起与子串的第一个字符进行比较，若相等，则继续逐对字符进行后续的比较；
    //  2. 若不相等，则从主串第二个字符起与子串的第一个字符重新比较，以此类推，
    //     直到子串中每个字符依次和主串中的一个连续的字符序列相等为止，此时称为匹配成功。
    //  3. 如果不能在主串中找到与子串相同的字符序列，则匹配失败。
    //* BF算法是最原始、最暴力的求解过程，但也是其他匹配算法的基础


    public static void bruteForce(String s, String p) {
        int index = -1;// 成功匹配的位置
        int sLength = s.length();// 主串长度
        int pLength = p.length();// 子串长度
        if (sLength < pLength) {
            System.out.println("Error.The main string is greater than the sub string length.");
            return;
        }
        int i = 0;
        int j = 0;
        while (i < sLength && j < pLength) {
            if (s.charAt(i) == p.charAt(j)) {// 判断对应位置的字符是否相等
                i++;// 若相等，主串、子串继续依次比较
                j++;
            } else {// 若不相等
                i = i - j + 1;// 主串回溯到上次开始匹配的下一个字符
                j = 0;// 子串从头开始重新匹配
            }
        }
        if (j >= pLength) {// 匹配成功
            index = i - j;
            System.out.println("Successful match,index is:" + index);
        } else {// 匹配失败
            System.out.println("Match failed.");
        }
    }

    //第一步构造next表
    public static int[] buildNext(String p){
        //构建next表就是查找真前缀 == 真后缀的最大长度，以获取模式串尽量多地往右移动
        int[] N = new int[p.length()];
        int m = p.length(),j = 0;//主串位置
        int t = N[0] = -1;//字串位置
        while(j < m -1){
            if(t < 0 || p.charAt(j) == p.charAt(t)){
                j++;t++;
                N[j] = t;
            }else{//失配
                t = N[t];
            }
        }
        return N;
    }
    //第二步利用next表尽量多地往右移动
    public static void kmp(String s, String p) {
        int[] next = buildNext(p);// 调用next（String p）方法
        int index = -1;// 成功匹配的位置
        int sLength = s.length();// 主串长度
        int pLength = p.length();// 子串长度
        if (sLength < pLength) {
            System.out.println("Error.The main string is greater than the sub string length.");
            return;
        }
        int i = 0;
        int j = 0;
        while (i < sLength && j < pLength) {
            /*
             * 如果j = -1， 或者当前字符匹配成功（即s.charAt(i) == p.charAt(j)）， 都令i++，j++
             * 这两个条件能否交换次序？
             */
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                /*
                 * 如果j != -1，且当前字符匹配失败， 则令 i 不变，j = next[j], next[j]即为j所对应的next值
                 */
                j = next[j];
            }
        }
        if (j >= pLength) {// 匹配成功
            index = i - j;
            System.out.println("Successful match,index is:" + index);
        } else {// 匹配失败
            System.out.println("Match failed.");
        }
    }

}
