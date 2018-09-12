package com.example.threadpool;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadPool {
    public static void main(String[] args) {
        //创建固定大小线程池
        ExecutorService executor = newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            SendNoticeTask task = new SendNoticeTask();
            task.setCount(i);
            executor.execute(task);
        }
        System.out.println("主线程结束");
    }
}
