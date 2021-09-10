package com.ham.my_algorithm.mythread;

public class ThreadPrint {
    private volatile int i = 0;
    private volatile int flag = 0;

    public static void main(String[] args) throws InterruptedException {
//        ThreadTest threadTest =new ThreadTest();
//        threadTest.runThread();
        ThreadPrint threadPrint = new ThreadPrint();
        threadPrint.print();

    }

    private void print() {
        new Thread(new run1()).start();
        new Thread(new run2()).start();
        new Thread(new run3()).start();
    }

    class run1 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 0) {
                    System.out.println("a=" + i);
                    i++;
                    flag = 1;
                }
            }
        }
    }

    class run2 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 1) {
                    System.out.println("b=" + i);
                    i++;

                    flag = 2;
                }
            }
        }
    }

    class run3 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                if (flag == 2) {
                    System.out.println("c=" + i);
                    i++;
                    flag = 0;
                }
            }
        }
    }
}
