package com.thread.syn.method;

public class Bank {
    private int count = 0;// �˻����

    public synchronized void addMoney(int money) { // ��Ǯ
        count += money;
        System.out.println(System.currentTimeMillis() + "�����" + money);
    }

    public synchronized void subMoney(int money) {// ȡǮ
        if (count - money < 0) {
            System.out.println("����");
            return;
        }
        count -= money;
        System.out.println(+System.currentTimeMillis() + "ȡ����" + money);
    }

    public void lookMoney() {// ��ѯ
        System.out.println("�˻���" + count);
    }
}
