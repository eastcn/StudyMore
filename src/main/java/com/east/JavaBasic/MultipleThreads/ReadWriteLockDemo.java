package com.east.JavaBasic.MultipleThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname ReadWriteLockDemo
 * @Description ReadWriteLock使用
 * 该ReadWriterLock主要用于实现：有写入时，只允许一个线程写入，没有写入时允许多个线程读取
 * ReadWriteLock是一个接口，ReentrantReadWriteLock是其实现类。
 * ReadWriterLock中会有一个readLock和一个writeLock，readLock允许获取多次个锁，writeLock只允许获取一次
 * @Date 2020/8/18 5:48 下午
 * @Created by East
 */
public class ReadWriteLockDemo {
    public static class Counter {
        public final ReadWriteLock rwLock = new ReentrantReadWriteLock();
        public final Lock rLock = rwLock.readLock(); // 指定一个读锁
        public final Lock wLock = rwLock.writeLock(); // 指定一个写锁

        public int count = 0;

        public void add(int n) {
            wLock.lock(); // 获取写锁
            System.out.println(Thread.currentThread() + " 写入加锁");
            try {
                System.out.println(Thread.currentThread() + "写入");
                count += n;
            } finally {
                wLock.unlock(); // 解锁
                System.out.println(Thread.currentThread() + " 写入解锁");
            }
        }

        public int get() {
            rLock.lock(); // 获取读锁
            System.out.println(Thread.currentThread() + "获取读锁");
            try {
                Thread.sleep(1000);
                return count;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rLock.unlock();
                System.out.println(Thread.currentThread() + " 读取解锁");
            }
            return 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(counter.get());
            }).start(); // new出以后直接start，如果在arrayList遍历且join的话会出现启动下一个线程需要等上一个线程结束
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                counter.add(1);
                System.out.println("add");
            });
            threadList.add(t);
        }
        for (Thread t : threadList
        ) {
            t.start();
            t.join();
        }
    }
}
