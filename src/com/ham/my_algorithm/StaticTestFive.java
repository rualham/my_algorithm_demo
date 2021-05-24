package com.ham.my_algorithm;

public class StaticTestFive {

    private static StaticTestFive test;

    static {
        System.out.println("test = " + 11111111);

        test = new StaticTestFive();
    }

    private static final String name = new String("string_name");
    private static final String name1 = "string_name";

    private String testName;

    private StaticTestFive() {
        System.out.println("test = " + 11111111);
        testName = name;
    }

    public static void main(String[] args) {
        System.out.println(test.testName); // 输出结果为: null
    }

}
