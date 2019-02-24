package com.thread.pool.cached;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����߳�
 * �����̳߳ش�С�ǲ���ֵ�����Ը�����Ҫ������ͬ�������̣߳���ʹ�û����ͳ�ʱ���Ȳ鿴������û����ǰ�������̣߳�����У��͸���.���û�У����½��µ��̼߳������.
 * �����ͳ���ͨ������ִ��һЩ�����ں̵ܶ��첽������.
 *
 * �̳߳�Ϊ���޴󣬵�ִ�е�ǰ����ʱ��һ�������Ѿ���ɣ��Ḵ��ִ����һ��������̣߳�������ÿ���½��̣߳���������Ǹ���ִ����һ��������̡߳�
 *
 * @author ZhangQingliang
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();// ����һ���ɻ����̳߳�
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);// sleep�����Կ���ʹ�õ����̳߳�������ǰ���̣߳�û�д����µ��߳�
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "���ڱ�ִ��");// ��ӡ����ִ�еĻ����߳���Ϣ
                }
            };
            cachedThreadPool.execute(runnable);
        }
    }
}
