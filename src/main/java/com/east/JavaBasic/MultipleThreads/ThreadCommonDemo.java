package com.east.JavaBasic.MultipleThreads;

/**
 * @Classname ThreadCommonDemo
 * @Description 线程操作：join、interrupt
 * 线程的状态： New -> Runnable|Blocked|Waiting|Time Waiting -> Terminated
 * 等待指定线程运行完成再执行以后的代码： join， 可传入参数long 类型指定等待多久的时间，超时则继续执行
 * 中断线程：    1. 需要run中实现检查当前线程是否处在 Interrupted状态
 *              2. 指定线程为join 并去打断它时会抛出Interrupted异常，捕获线程的Interrupted异常
 *              3. 设置一个线程之间共享的标志位，并且在run方法中实现对该标志位的判断，当为特定值时打断，需要用到关键字
 * @Date 2020/8/18 12:10 上午
 * @Created by East
 */
public class ThreadCommonDemo {
    public static void main(String[] args) throws InterruptedException {
        // 不同方法的实现
        CreateThreadsDemo.MyThread myThread = new CreateThreadsDemo.MyThread();
        CreateThreadsDemo.MyRunnable myRunnable = new CreateThreadsDemo.MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable);
        CreateThreadsDemo.flagThread myFlagThread = new CreateThreadsDemo.flagThread();

        myThread.start();
        myRunnableThread.start();
        myFlagThread.start();

        Thread.sleep(101);
        myFlagThread.flag = false;
        myRunnableThread.interrupt();
        myRunnableThread.join();
        myThread.join(); // 等待该线程执行完成才会执行之后的代码
        System.out.println("main is over " + Thread.currentThread());
    }

}
