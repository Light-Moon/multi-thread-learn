package com.thread.create.method3;

public class MyThread {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (5 == i) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + i);
                        }

                    }
                });
                thread.start();
            }
        }
    }
}
