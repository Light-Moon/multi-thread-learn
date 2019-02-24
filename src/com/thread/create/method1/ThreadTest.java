package com.thread.create.method1;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (5 == i) {
                Thread myThread1 = new MyThread();// 创建一个新的线程myThread1
                MyThread myThread2 = new MyThread();// 创建一个新的线程 myThread2
                myThread1.start();// 调用start()方法使得线程进入就绪状态
                myThread2.start();// 调用start()方法使得线程进入就绪状态
            }
        }
    }
}
