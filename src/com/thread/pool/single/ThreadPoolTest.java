package com.thread.pool.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ�����񣬱�֤����������ָ��˳��(FIFO, LIFO, ���ȼ�)ִ�С�
 * ���н����ֻ�ᴴ��һ���̣߳�����һ��ִ����֮��Ż�ִ�еڶ���
 *
 * @author ZhangQingliang
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();// ����һ�����̻߳����̳߳�
        for (int i = 0; i < 10; i++) {
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "���ڱ�ִ��, index = " + index);// �������������൱��˳��ִ�и�������
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            singleThreadPool.execute(runnable);
        }
    }
}
