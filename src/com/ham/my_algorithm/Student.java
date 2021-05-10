package com.ham.my_algorithm;

public class Student {
    String name = "name";

    public void test() {

        System.out.println(this.getClass().getClassLoader().toString());
        System.out.println(this.getClass().getClassLoader());
    }

    public void hello() {
    }
}
