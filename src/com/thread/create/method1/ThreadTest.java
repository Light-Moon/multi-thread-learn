package com.thread.create.method1;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (5 == i) {
                Thread myThread1 = new MyThread();// ����һ���µ��߳�myThread1
                MyThread myThread2 = new MyThread();// ����һ���µ��߳� myThread2
                myThread1.start();// ����start()����ʹ���߳̽������״̬
                myThread2.start();// ����start()����ʹ���߳̽������״̬
            }
        }
    }
}
