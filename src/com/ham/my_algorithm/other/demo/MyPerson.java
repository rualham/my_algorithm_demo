package com.ham.my_algorithm.other.demo;

public class MyPerson {

    //静态变量
    public static int staicVariabl = 10;

    //成员变量
    public int objVariabl;

    //静态初始代码块
    static {
        staicVariabl = 2;
        System.out.println("staicVariabl = " + staicVariabl);
    }

    //对象初始化代码块
    {
        objVariabl = 88;
    }

    //构造方法
    public MyPerson() {
        objVariabl = 99;
    }

    public static void main(String[] args) {
        MyPerson person = new MyPerson();
    }
}
