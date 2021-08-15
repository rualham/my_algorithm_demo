package com.ham.my_algorithm.stringdemo;

public class StringNull {

    //空格字符串

    public static void main(String[] args) {
        String a = replaceSpace(new StringBuffer("We are ham"));
        String b = replaceSpace(new StringBuffer("We are ham"));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }


    public static String replaceSpace1(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
