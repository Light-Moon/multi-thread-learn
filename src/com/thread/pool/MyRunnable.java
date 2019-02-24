package com.thread.pool;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
