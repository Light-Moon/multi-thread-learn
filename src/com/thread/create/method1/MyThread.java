package com.thread.create.method1;

public class MyThread extends Thread {
    @Override
    public void run() {// run�����б�д ���߳���Ҫִ�еĴ���
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
