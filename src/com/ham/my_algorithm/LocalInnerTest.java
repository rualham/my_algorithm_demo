package com.ham.my_algorithm;

public class LocalInnerTest {
    private int a = 1;
    private static int b = 2;

    public void test() {
         int c = 3;
        class LocalInner {
            public void add1() {
                System.out.println("a= " + a);
                System.out.println("b= " + b);
                System.out.println("c= " + c);
            }
        }
        new LocalInner().add1();
    }

    static public void test2() {
         int d = 5;
        class LocalInner2 {
            public void add1() {
                // System.out.println("a= " + a);
                System.out.println("b= " + b);
                System.out.println("c= " + d);
            }
        }
        LocalInnerTest localInnerTest=new LocalInnerTest();
        localInnerTest.test2();
        new LocalInner2().add1();
    }

    public static void main(String args[]) {
        LocalInnerTest lc = new LocalInnerTest();
        new LocalInnerTest().test2();
        new LocalInnerTest().test();
    }
}