package com.thread.syn.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int count = 0;// 账户余额
    private Lock lock = new ReentrantLock();

    public void addMoney(int money) { // 存钱
        lock.lock();// 上锁
        try {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);
        } finally {
            lock.unlock();// 解锁
        }

    }

    public void subMoney(int money) {// 取钱
        lock.lock();// 上锁
        try {
            if (count - money < 0) {
                System.out.println("余额不足");
                return;
            }
            count -= money;
            System.out.println(+System.currentTimeMillis() + "取出：" + money);
        } finally {
            lock.unlock();// 解锁
        }

    }

    public void lookMoney() {// 查询
        System.out.println("账户余额：" + count);
    }
}
