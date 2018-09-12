package com.example.thread.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest1 {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");

        lock.lock(); // 获取锁
        try {
            System.out.println(Thread.currentThread().getName()+" 1 start ta");
            ta.start();

            System.out.println(Thread.currentThread().getName()+" 2 block");
            condition.await();    // 等待

            System.out.println(Thread.currentThread().getName()+" 3 continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();    // 释放锁
        }
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            lock.lock();    // 获取锁
            try {
                System.out.println(Thread.currentThread().getName()+" wakup others");
                condition.signal();    // 唤醒“condition所在锁上的其它线程”
            } finally {
                lock.unlock();    // 释放锁
            }
        }
    }
}