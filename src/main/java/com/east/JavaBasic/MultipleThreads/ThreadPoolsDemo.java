package com.east.JavaBasic.MultipleThreads;

import sun.management.VMOptionCompositeData;

import java.util.concurrent.*;

/**
 * @Classname ThreadPoolsDemo
 * @Description 线程池实现，java提供了三种线程池的实现方式
 * 1、FixedThreadPool：固定线程数
 * 2、CachedThreadPool：根据任务书 动态调整
 * 3、SingleThreadPool：仅单线程执行
 * @Date 2020/8/18 9:55 下午
 * @Created by East
 */
public class ThreadPoolsDemo {


    /**
     * 一个Runnable的接口实现类
     */
    static class Task implements Runnable {
        public String name;

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task Start" + name + Thread.currentThread());
        }

        public Task(String n) {
            name = n;
        }
    }

    /**
     * 向固定线程的线程池提交任务后，会分配给空闲的线程去执行，如果没有空闲的则等待，有空闲才会执行之后的任务
     */
    public void fixedPool() throws InterruptedException {
        // 实例化一个固定5个线程的线程池，该方法包含在Executors类中
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Task("FixedPool" + i));
        }
        executorService.shutdown(); // 等待正在执行的线程结束才会关闭
        // executorService.shutdownNow(); // 会立刻关闭
        executorService.awaitTermination(10, TimeUnit.SECONDS); // 并没有关闭的作用，用于判断固定时间后是否关闭
    }

    /**
     * 根据提交的任务数来动态调整
     */
    public static void cachedPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.submit(new Task("FixedPool" + i));
        }
        cachedThreadPool.shutdown();
    }

    /**
     * 创建一个指定范围大小的线程池
     */
    public static void newCachedPool(int min, int max) {
        ExecutorService es = new ThreadPoolExecutor(min, max, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            es.submit(new Task("FixedPool" + i));
        }
        es.shutdown();

    }

    public static void schedulerThreadPool(){
        // 需要指定为ScheduledExecutorService
        ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
        es.schedule(new Task("one-time"),1,TimeUnit.SECONDS);// 提交只执行一次的任务，并设置1秒后开始执行
        es.scheduleAtFixedRate(new Task("fixed rate"),2,3,TimeUnit.SECONDS); // 间隔3秒执行一次任务
        es.scheduleWithFixedDelay(new Task("fixed delay"),2,3,TimeUnit.SECONDS); // 上一次任务完成后间隔3秒执行

    }

    public static void main(String[] args) {
        cachedPool();
        newCachedPool(4,6);
    }
}
