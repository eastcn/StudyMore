package com.east.JavaBasic.MultipleThreads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname OtherLocksDemo
 * @Description ReentrantLock
 * @Date 2020/8/18 4:27 下午
 * @Created by East
 */
public class ReentrantLockDemo {
    /**
     * ReentrantLock是java实现的，因此需要捕获异常
     * ReentrantLock可以指定获取锁的等待时间，如果指定的时间内没有获取到锁就返回false
     */
    static class ReentrantLockCounter {
        public Lock lock = new ReentrantLock();
        public int count = 0;

        public void add() {
            lock.lock(); // 此处代表获取锁
            try {
                count += 1;
            } finally {
                lock.unlock();// 必须要解锁，无论是否出现异常都需要解锁
            }
        }

        public void minus() throws InterruptedException {
            if (lock.tryLock(1, TimeUnit.SECONDS)) { // ReentrantLock可以指定等待时间，如果超过指定时间没有获取到锁，则返回false
                try {
                    count -= 1;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * condition demo，使用ReentrantLock时需要实例化一个Condition对象来协调线程执行
     * Condition 必须通过Lock类对象的newCondition方法实例化，跟一个锁绑定。
     * await：释放锁，线程进入等待状态，等待被其他线程唤醒。可以设置等待时间，如果超过时间则返回false
     * signal：唤醒一个其他在等待的线程
     * signalAll：唤醒所有在等待的线程
     */
    static class TaskQueue {
        public Lock lock = new ReentrantLock();
        public Queue<String> queue = new LinkedList<String>();
        public Condition condition = lock.newCondition(); // Condition实例化必须从lock中实例化

        public void add(String task) {
            lock.lock(); // 获取锁
            try {
                queue.add(task);
                condition.signalAll(); // 唤醒所有的线程
                condition.signal(); // 唤醒单个线程
            } finally {
                lock.unlock(); // 解锁
            }
        }
        
        public String getTask() throws InterruptedException {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    condition.await(); // 等待被唤醒，如果唤醒则继续执行
                }
                return queue.remove();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 如果在1秒钟内没有被唤醒，则返回空
         */
        public String getOrNull() throws InterruptedException {
            lock.lock(); // 上锁
            try {
                if (condition.await(1, TimeUnit.SECONDS)) { // 判断1秒钟内是否被唤醒如没被唤醒则返回false，类似tryLock
                    return queue.remove();
                } else {
                    return null;
                }
            } finally {
                lock.unlock(); // 解锁
            }
        }
    }

    public static void main(String[] args) {

    }
}
