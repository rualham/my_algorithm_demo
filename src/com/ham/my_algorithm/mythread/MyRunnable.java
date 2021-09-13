package com.ham.my_algorithm.mythread;

public class MyRunnable implements Runnable {
 /*   @Override
    public void run(int a) {
        for (int i = 0; i < a; i++) {
            System.out.println("i = " + i);

        }
    }*/

    public static void main(String[] args) {
        Thread a = new Thread(new MyRunnable());
        a.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);

        }
    }
}
