package com.east.JavaBasic.MultipleThreads;

/**
 * @Classname DaemonThread
 * @Description 守护线程，即，为其他线程服务的线程，当其他非守护线程都执行完成后，JVM进程就会退出，而不关心守护线程是否结束
 * @Date 2020/8/18 12:58 上午
 * @Created by East
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        CreateThreadsDemo.flagThread daemonThread = new CreateThreadsDemo.flagThread();
        CreateThreadsDemo.MyThread myThread = new CreateThreadsDemo.MyThread();

        // 把该线程设为守护线程
        daemonThread.setDaemon(true);
        myThread.start();
        daemonThread.start();
        myThread.join();
        System.out.println("main thread over");
    }
}
