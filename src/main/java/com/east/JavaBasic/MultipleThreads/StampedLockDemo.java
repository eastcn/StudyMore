package com.east.JavaBasic.MultipleThreads;

import java.util.concurrent.locks.StampedLock;

/**
 * @Classname StampedLockDemo
 * @Description StampedLock进一步提高并发效率
 * 这个锁是一种乐观锁，ReadWriteLock是一种悲观锁
 * @Date 2020/8/18 6:17 下午
 * @Created by East
 */
public class StampedLockDemo {
    /**
     * 实现一个点的类
     */
    static class point {
        private final StampedLock stampedLock = new StampedLock(); // 实例化一个StampedLock对象
        private double x;
        private double y;

        /**
         * 移动点的位置，写入锁与ReadWriterLock等一样，获取到锁才能修改，不管发生什么最后都需要释放
         */
        public void move(double deltaX, double deltaY) throws InterruptedException {
            Thread.sleep(50); // 模拟中途介入写方法
            long stampedVersion = stampedLock.writeLock(); // 获取一个写的锁，返回的为这个写锁的版本号
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                stampedLock.unlock(stampedVersion); // 释放掉该版本号的写锁
            }
        }

        /**
         * 实现计算该点距离原点的距离。
         * 主要理解点在于：
         * 开始先获取乐观锁，乐观锁的读锁是允许写锁插队的，所以在乐观锁的过程中
         */
        public double distanceFromOrigin() throws InterruptedException {
            Thread.sleep(50);
            long stampVersion = stampedLock.tryOptimisticRead(); // 获取一个读的乐观锁(其实根本不是锁，只是一个版本号，用于校验)
            double currentX = x;
            double currentY = y;
            System.out.println(Thread.currentThread() + "当前x和y为：" + currentX + currentY);
            // 因为有写线程的存在，这两个获取到的值有可能与之前的不一样，
            // 所以要判断获取到该读乐观锁后是否有获取写锁，如果有则需要获取一遍读的悲观锁，并重新获取x，y的值
            if (stampedLock.validate(stampVersion)) {
                stampVersion = stampedLock.readLock(); // 获取一个悲观的读锁，覆盖之前的乐观锁
                System.out.println(Thread.currentThread() + "获取悲观锁");
                try {
                    currentX = x;
                    currentY = y;
                    System.out.println(Thread.currentThread() + "当前x和y为：" + currentX + currentY);
                } finally {
                    stampedLock.unlock(stampVersion); // 释放该悲观的读锁
                    System.out.println(Thread.currentThread() + "解锁");
                }
            }
            return Math.sqrt(currentX * currentX + currentY + currentY); // 返回其距离原点的距离
        }
    }

    public static void main(String[] args) throws InterruptedException {
        point p = new point();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    p.distanceFromOrigin();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread t = new Thread(()->{
            try {
                System.out.println("move");
                p.move(1000.0, 2000.0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();
    }
}

