package com.thread.create.method1;

public class MyThread extends Thread {
    @Override
    public void run() {// run方法中编写 多线程需要执行的代码
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
