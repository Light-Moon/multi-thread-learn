package com.thread.syn.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int count = 0;// �˻����
    private Lock lock = new ReentrantLock();

    public void addMoney(int money) { // ��Ǯ
        lock.lock();// ����
        try {
            count += money;
            System.out.println(System.currentTimeMillis() + "�����" + money);
        } finally {
            lock.unlock();// ����
        }

    }

    public void subMoney(int money) {// ȡǮ
        lock.lock();// ����
        try {
            if (count - money < 0) {
                System.out.println("����");
                return;
            }
            count -= money;
            System.out.println(+System.currentTimeMillis() + "ȡ����" + money);
        } finally {
            lock.unlock();// ����
        }

    }

    public void lookMoney() {// ��ѯ
        System.out.println("�˻���" + count);
    }
}
