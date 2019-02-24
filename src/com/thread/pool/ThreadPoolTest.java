package com.thread.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过此程序来观察线程池的工作原理。从结果可以观察出：
 *
 * 1、创建的线程池具体配置为：核心线程数量为5个；全部线程数量为10个；工作队列的长度为5。
 * 2、我们通过queue.size()的方法来获取工作队列中的任务数。
 * 3、运行原理：刚开始都是在创建新的线程，达到核心线程数量5个后，新的任务进来后不再创建新的线程，而是将任务加入工作队列，任务队列到达上线5个后，
 * 新的任务又会创建新的普通线程，直到达到线程池最大的线程数量10个，后面的任务则根据配置的饱和策略来处理。我们这里没有具体配置，
 * 使用的是默认的配置AbortPolicy:直接抛出异常。 当然，为了达到我需要的效果，上述线程处理的任务都是利用休眠导致线程没有释放！！！
 *
 * @author ZhangQingliang
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<Runnable>(5);
        // ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize,
        // maximumPoolSize, keepAliveTime, unit, workQueue);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 13; i++) {
            Runnable runnable = new MyRunnable();
            Thread thread = new Thread(runnable, "Thread" + i);
            threadPool.execute(thread);
            // threadPool.execute(new Thread(new MyRunnable(), "Thread" + i));
            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0) {
                System.out.println("*************任务队列中阻塞的线程数： " + queue.size());
            }
        }
        System.out.println(threadPool.getPoolSize());
        Thread.sleep(15000);
        System.out.println(threadPool.getPoolSize());
        threadPool.shutdown();
    }
}
