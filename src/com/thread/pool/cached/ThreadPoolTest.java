package com.thread.pool.cached;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
 * 缓存线程池大小是不定值，可以根据需要创建不同数量的线程，在使用缓存型池时，先查看池中有没有以前创建的线程，如果有，就复用.如果没有，就新建新的线程加入池中.
 * 缓存型池子通常用于执行一些生存期很短的异步型任务.
 *
 * 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程，本程序就是复用执行上一个任务的线程。
 *
 * @author ZhangQingliang
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();// 创建一个可缓存线程池
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);// sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在被执行");// 打印正在执行的缓存线程信息
                }
            };
            cachedThreadPool.execute(runnable);
        }
    }
}
