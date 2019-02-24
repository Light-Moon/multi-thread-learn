package com.thread.pool.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool����һ�������̳߳أ�֧�ֶ�ʱ������������ִ��,��������¿��������Timer�ࡣ
 *
 * scheduleAtFixedRate(Runnable command, long initialDelay, long period,
 * TimeUnitunit) ������ִ��һ���ڸ�����ʼ�ӳٺ��״����õĶ��ڲ����������������и��������ڣ�Ҳ���ǽ��� initialDelay
 * ��ʼִ�У�Ȼ����initialDelay+period��ִ�У������� initialDelay + 2 * period ��ִ�У���������
 *
 * @author ZhangQingliang
 *
 */
public class ScheduleAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("�ӳ�1���ÿ3��ִ��һ��");
                }
            };
            scheduledThreadPool.scheduleAtFixedRate(runnable, 1, 3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(30000);// 30���ر��̳߳�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
    }
}