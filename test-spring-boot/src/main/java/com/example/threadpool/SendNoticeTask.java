package com.example.threadpool;

public class SendNoticeTask implements Runnable {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to" + " send " + count + " ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}