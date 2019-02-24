package com.thread.pool.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool����һ�������̳߳أ�֧�ֶ�ʱ������������ִ��,��������¿��������Timer�ࡣ
 *
 * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
 * TimeUnit unit) ������ִ��һ���ڸ�����ʼ�ӳٺ��״����õĶ��ڲ����������ÿһ��ִ����ֹ����һ��ִ�п�ʼ֮�䶼���ڸ������ӳ١�
 *
 * @author ZhangQingliang
 *
 */
public class ScheduleWithFixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("�ӳ�1���ÿִ����ֹ��3��������ִ��");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("һ��ִ�н���");
                }
            };
            scheduledThreadPool.scheduleWithFixedDelay(runnable, 1, 3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(60000);// 60���ر��̳߳�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
    }
}