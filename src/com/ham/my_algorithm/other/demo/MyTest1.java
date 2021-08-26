package com.ham.my_algorithm.other.demo;

public class MyTest1 {

    public static void main(String[] args) {
        MyThread a = new MyThread("my");
//        a.start();
//        a.run();
        for (int j = 0; j < 100; j++) {
//            System.out.println("test1.main()----" + j);
        }
        //线程模拟买票
        HelloThread t = new HelloThread();
        Thread thread1 = new Thread(t, "1号窗口");
        thread1.start();
        Thread thread2 = new Thread(t, "2号窗口");
        thread2.start();
    }


    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("MyThread.run()..." + i + "  " + Thread.currentThread().getName());
            }   /*单条线程运行一百次*/
        }
    }

    static class HelloThread implements Runnable {
        private int ticket = 5;

        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + (ticket--));

                if (ticket < 1) {
                    break;

                }
            }
        }
    }
}
