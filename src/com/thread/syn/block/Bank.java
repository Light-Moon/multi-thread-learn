package com.thread.syn.block;

public class Bank {
    private int count = 0;// �˻����

    public void addMoney(int money) { // ��Ǯ
        synchronized (this) {
            count += money;
        }
        System.out.println(System.currentTimeMillis() + "�����" + money);
    }

    public synchronized void subMoney(int money) {// ȡǮ
        synchronized (this) {
            if (count - money < 0) {
                System.out.println("����");
                return;
            }
            count -= money;
        }
        System.out.println(+System.currentTimeMillis() + "ȡ����" + money);
    }

    public void lookMoney() {// ��ѯ
        System.out.println("�˻���" + count);
    }
}
