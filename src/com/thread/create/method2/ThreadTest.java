package com.thread.create.method2;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (5 == i) {
                Runnable myRunnable = new MyRunnable();// 创建一个Runnable实现类的对象
                // MyRunnable myRunnable = new MyRunnable();
                Thread thread = new Thread(myRunnable);// 创建新的线程
                thread.start();
            }
        }
    }
}
