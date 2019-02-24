package com.thread.pool.fixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。 总共只会创建n个线程，
 * 开始执行n个线程，当n个线程都处于活动状态，再次提交的任务都会加入队列等到其他线程运行结束，当线程处于空闲状态时会被下一个任务复用
 *
 * 此程序因为线程池大小为3，每个任务输出打印结果后sleep 2秒，所以每两秒打印3个结果。
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
 *
 * @author ZhangQingliang
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3); // 创建一个可重用固定个数的线程池
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "正在被执行");// 打印正在执行的缓存线程信息
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            fixedThreadPool.execute(runnable);
        }
    }
}
