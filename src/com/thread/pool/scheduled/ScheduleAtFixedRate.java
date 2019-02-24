package com.thread.pool.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行,多数情况下可用来替代Timer类。
 *
 * scheduleAtFixedRate(Runnable command, long initialDelay, long period,
 * TimeUnitunit) 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay
 * 后开始执行，然后在initialDelay+period后执行，接着在 initialDelay + 2 * period 后执行，依此类推
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
                    System.out.println("延迟1秒后每3秒执行一次");
                }
            };
            scheduledThreadPool.scheduleAtFixedRate(runnable, 1, 3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(30000);// 30秒后关闭线程池
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
    }
}