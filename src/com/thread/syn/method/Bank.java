package com.thread.syn.method;

public class Bank {
    private int count = 0;// 账户余额

    public synchronized void addMoney(int money) { // 存钱
        count += money;
        System.out.println(System.currentTimeMillis() + "存进：" + money);
    }

    public synchronized void subMoney(int money) {// 取钱
        if (count - money < 0) {
            System.out.println("余额不足");
            return;
        }
        count -= money;
        System.out.println(+System.currentTimeMillis() + "取出：" + money);
    }

    public void lookMoney() {// 查询
        System.out.println("账户余额：" + count);
    }
}
