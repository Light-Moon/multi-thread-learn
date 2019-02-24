package com.thread.pool.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 运行结果：只会创建一个线程，当上一个执行完之后才会执行第二个
 *
 * @author ZhangQingliang
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();// 创建一个单线程化的线程池
        for (int i = 0; i < 10; i++) {
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "正在被执行, index = " + index);// 结果依次输出，相当于顺序执行各个任务
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
