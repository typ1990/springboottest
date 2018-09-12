package com.example.concurrent.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnableRef = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnableRef);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnableRef);
        threadB.setName("B");
        threadB.start();
        threadB.interrupt();// 打标记
        System.out.println("main end!");
    }

    public static class MyService {

        public ReentrantLock lock = new ReentrantLock();

        public void waitMethod() {
            try {
                try {
                    lock.lockInterruptibly();

                    System.out
                            .println("lock begin " + Thread.currentThread().getName());
                    for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
                        String newString = new String();
                        Math.random();
                    }
                    System.out
                            .println("lock   end " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out
                            .println("线程进入异常 " + Thread.currentThread().getName());
                    e.printStackTrace();
                }
                ;
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }

    }
}
