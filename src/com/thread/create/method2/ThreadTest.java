package com.thread.create.method2;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (5 == i) {
                Runnable myRunnable = new MyRunnable();// ����һ��Runnableʵ����Ķ���
                // MyRunnable myRunnable = new MyRunnable();
                Thread thread = new Thread(myRunnable);// �����µ��߳�
                thread.start();
            }
        }
    }
}
