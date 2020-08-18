package com.east.JavaBasic.MultipleThreads;

/**
 * @Classname SynchronizedDemo
 * @Description 线程同步Demo
 * 1、synchronized 同步
 * 2、线程同步在实践过程中最好是将需要同步操作的逻辑代码封装起来，而不是在run方法中实现
 * @Date 2020/8/18 10:27 上午
 * @Created by East
 */
public class SynchronizedDemo {
    static class Count {
        // 实例一个Object对象作为lock
        static public final Object lock = new Object();
        static public int count = 0;

        // 把同步操作封装在方法中，这样线程调用时就不需要关心是同步问题
        // 该方法中锁住的this，即为锁住当前类的实例对象，因此当实例化多个Count对象时，其数据互不影响
        // 一个类被设计为允许多线程正确访问，我们就说这个类就是“线程安全”的（thread-safe），此处Count即为线程安全

        public void add(int n) {
            synchronized (this) { // 锁住this实例
                count += n;
            }// 释放锁
        }

        // 以上方法可以简化为如下
        public synchronized void minus(int n) { // 锁住this实例
            count -= n;
        }// 释放锁

        // 如果是静态变量,synchronized锁住的则是Count.class
        public static synchronized void minus1(){
            count -= 1;
        }

    }

    static class syThread1 extends Thread {
        @Override
        public void run() {
            System.out.println(currentThread() + " add start");
            for (int i = 0; i < 10000; i++) {
                synchronized (Count.lock) { // 此处获取到锁
                    Count.count += 1;
                } // 此处释放掉锁
            }
            System.out.println(currentThread() + " add over");
        }
    }

    static class syThread2 extends Thread {
        @Override
        public void run() {
            System.out.println(currentThread() + "minus start");
            for (int i = 0; i < 10000; i++) {
                synchronized (Count.lock) {
                    Count.count -= 1;
                }
            }
            System.out.println(currentThread() + "minus over");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 1. 测试线程同步，synchronized
        syThread1 thread1 = new syThread1();
        syThread2 thread2 = new syThread2();
        thread1.start();
        thread2.start();
        // 如果不设置等待，则最后打印的count不是最终结果
        thread1.join();
        thread2.join();
        System.out.println("main thread over, count=" + Count.count);
    }

}
