package com.thread.create.method4;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {// 与run()方法不同的是，call()方法具有返回值
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
