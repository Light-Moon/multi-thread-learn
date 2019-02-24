package com.thread.create.method4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {
        Callable<Integer> myCallable = new MyCallable();// ����MyCallable����
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); // ʹ��FutureTask����װMyCallable����
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 5) {
                Thread thread = new Thread(ft); // FutureTask������ΪThread�����target�����µ��߳�
                thread.start(); // �߳̽��뵽����״̬
            }
        }
        System.out.println("���߳�forѭ��ִ�����..");
        try {
            int sum = ft.get(); // ȡ���´��������߳��е�call()�������صĽ��
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}