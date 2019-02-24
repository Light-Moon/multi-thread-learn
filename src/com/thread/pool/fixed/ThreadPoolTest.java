package com.thread.pool.fixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool����һ�������ù̶��߳������̳߳أ��Թ�����޽���з�ʽ��������Щ�̡߳� �ܹ�ֻ�ᴴ��n���̣߳�
 * ��ʼִ��n���̣߳���n���̶߳����ڻ״̬���ٴ��ύ�����񶼻������еȵ������߳����н��������̴߳��ڿ���״̬ʱ�ᱻ��һ��������
 *
 * �˳�����Ϊ�̳߳ش�СΪ3��ÿ�����������ӡ�����sleep 2�룬����ÿ�����ӡ3�������
 * �����̳߳صĴ�С��ø���ϵͳ��Դ�������á���Runtime.getRuntime().availableProcessors()
 *
 * @author ZhangQingliang
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3); // ����һ�������ù̶��������̳߳�
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "���ڱ�ִ��");// ��ӡ����ִ�еĻ����߳���Ϣ
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
