package com.ham.my_algorithm.other.demo;

public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread1()).start();
        Thread.sleep(3000);//主动让出CPU，让CPU去执行其他的线程。在sleep指定的时间后，CPU回到这个线程上继续往下执行
        new Thread(new Thread2()).start();

    }
}


class Thread1 implements Runnable {
    @Override
    public void run() {
        synchronized (MultiThread.class) {
            System.out.println("进入线程1");
            try {
                System.out.println("线程1正在等待");
                Thread.sleep(3000);
                MultiThread.class.wait();//wait是指一个已经进入同步锁的线程内（此处指Thread1），让自己暂时让出同步锁，
                //以便其他在等待此锁的线程(此处指Thread2)可以得到同步锁并运行。
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("线程1结束等待，继续执行");
            System.out.println("线程1执行结束");
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        synchronized (MultiThread.class) {
            System.out.println("进入线程2");
            System.out.println("线程2唤醒其他线程");
            MultiThread.class.notify();//Thread2调用了notify()方法，但该方法不会释放对象锁，只是告诉调用wait方法的线程可以去
            //参与获得锁的竞争了。但不会马上得到锁，因为锁还在别人手里，别人还没有释放。如果notify()
            //后面的代码还有很多，需要执行完这些代码才会释放锁。
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2继续执行");
            System.out.println("线程2执行结束");
        }
    }
}