package com.thread.pool.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行,多数情况下可用来替代Timer类。
 * schedule(Runnable command,long delay, TimeUnit unit)创建并执行在给定延迟后启用的一次性操作
 *
 * 运行结果和newFixedThreadPool类似，不同的是newScheduledThreadPool是延时一定时间之后才执行.
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
                    System.out.println("延时3秒执行。");

                }
            };
            scheduledThreadPool.schedule(runnable, 3, TimeUnit.SECONDS);
        }
    }
}
