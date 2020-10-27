package com.ham.my_algorithm;

public class SingleInstance {

    private static class SingleInstanceHolder {
        static SingleInstance singleInstance = new SingleInstance();
    }

    public static SingleInstance getInstance() {
        return SingleInstanceHolder.singleInstance;
    }
}
