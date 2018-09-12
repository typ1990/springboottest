package com.example.thread.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest1 {

    private static Thread mainThread;

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+" 1 start ta");
        ta.start();

        System.out.println(Thread.currentThread().getName()+" 2 block "+System.currentTimeMillis() );
        // 主线程阻塞
        LockSupport.park(mainThread);

        System.out.println(Thread.currentThread().getName()+" 4 continue");
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+" 3 wakup others "+System.currentTimeMillis() );
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);
        }
    }
}