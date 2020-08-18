package com.east.JavaBasic.MultipleThreads;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname SynchronizedWaitDemo
 * @Description 线程协调
 * wait：只有在获取锁的方法中使用，使线程进入等待状态，并释放当前获取到的锁，若等待状态结束则又会获取锁
 * notify：唤醒一个获取当前锁的并且为waiting状态的线程
 * notifyAll：唤醒全部
 * @Date 2020/8/18 4:08 下午
 * @Created by East
 */
public class SynchronizedWaitDemo {
    static class taskQueue {
        Queue<String> queue = new LinkedList<String>();

        public synchronized void add(String string) {
            queue.add(string);
            this.notifyAll(); // 唤醒所有的线程
        }

        public synchronized String getFirst() throws InterruptedException {
            while (queue.isEmpty()) {
                this.wait(); // 如果为空则线程进入等待
            }
            return queue.remove();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        taskQueue task = new taskQueue();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.add("1");
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(task.getFirst());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start(); // 如果没有启动t1则t2会一直等待
        t1.start();
        t2.join();
    }
}
