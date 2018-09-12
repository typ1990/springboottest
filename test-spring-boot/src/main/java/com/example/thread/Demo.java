package com.example.thread;

public class Demo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()
                +"(isDaemon="+Thread.currentThread().isDaemon()+ ")");

        Thread t1=new MyThread("t1");    // 新建t1
        Thread t2=new MyDaemon("t2");    // 新建t2
        t2.setDaemon(true);                // 设置t2为守护线程
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}