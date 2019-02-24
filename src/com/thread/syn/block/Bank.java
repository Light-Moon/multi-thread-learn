package com.thread.syn.block;

public class Bank {
    private int count = 0;// ’Àªß”‡∂Ó

    public void addMoney(int money) { // ¥Ê«Æ
        synchronized (this) {
            count += money;
        }
        System.out.println(System.currentTimeMillis() + "¥ÊΩ¯£∫" + money);
    }

    public synchronized void subMoney(int money) {// »°«Æ
        synchronized (this) {
            if (count - money < 0) {
                System.out.println("”‡∂Ó≤ª◊„");
                return;
            }
            count -= money;
        }
        System.out.println(+System.currentTimeMillis() + "»°≥ˆ£∫" + money);
    }

    public void lookMoney() {// ≤È—Ø
        System.out.println("’Àªß”‡∂Ó£∫" + count);
    }
}
