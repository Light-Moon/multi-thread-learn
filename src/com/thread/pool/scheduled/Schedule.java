package com.thread.pool.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool����һ�������̳߳أ�֧�ֶ�ʱ������������ִ��,��������¿��������Timer�ࡣ
 * schedule(Runnable command,long delay, TimeUnit unit)������ִ���ڸ����ӳٺ����õ�һ���Բ���
 *
 * ���н����newFixedThreadPool���ƣ���ͬ����newScheduledThreadPool����ʱһ��ʱ��֮���ִ��.
 *
 * @author ZhangQingliang
 *
 */
public class Schedule {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("��ʱ3��ִ�С�");

                }
            };
            scheduledThreadPool.schedule(runnable, 3, TimeUnit.SECONDS);
        }
    }
}
