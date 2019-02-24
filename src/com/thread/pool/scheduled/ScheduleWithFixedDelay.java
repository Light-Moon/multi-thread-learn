package com.thread.pool.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行,多数情况下可用来替代Timer类。
 *
 * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
 * TimeUnit unit) 创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟。
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
                    System.out.println("延迟1秒后每执行终止后3秒再重新执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("一次执行结束");
                }
            };
            scheduledThreadPool.scheduleWithFixedDelay(runnable, 1, 3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(60000);// 60秒后关闭线程池
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
    }
}