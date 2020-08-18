package com.east.JavaBasic.MultipleThreads;

import static java.lang.Thread.sleep;

/**
 * @Classname CreateThreadsDemo
 * @Description 创建多线程的三种方法：
 * 1、继承Thread并重写run方法
 * 2、构造Runnable接口并在实例化Thread类的时候传入
 * @Date 2020/8/17 11:06 下午
 * @Created by East
 */
public class CreateThreadsDemo {
    /**
     * demo1: 通过继承Thread类然后重写run方法，去新建一个新的线程
     */
    static class MyThread extends Thread {
        // 注意： 直接调用run方法是无效的，run方法只是一个逻辑代码实现的方法且run方法只能为void，start才是去开启新线程的方法
        @Override
        public void run() {
            // 因为是继承了Thread类所以可以直接调用其static方法，currentThread
            System.out.println("new thread by extends Thread run.. " + currentThread());
            try {
                sleep(2000);
                System.out.println("new thread by extends Thread end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Demo2：构造Runnable接口，优点在于其还可以继承其他类
     */
    static class MyRunnable implements Runnable {
        // 实现Runnable接口 来新建线程
        @Override
        public void run() {
            System.out.println("this is new thread by Runnable run " + Thread.currentThread());
            try {
                sleep(100);
                int n = 0;
                while (!Thread.currentThread().isInterrupted()) {
//                    System.out.println("检测当前线程状态");
                    n++;
                }
                System.out.println("执行了" + n + "次" + Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println("被打断了");
//                e.printStackTrace();
            }
            System.out.println("this is new thread by Runnable end.." + Thread.currentThread());
        }
    }

    /**
     * 使用标志位来控制线程的运行和中断
     */
    static class flagThread extends Thread {
        public volatile boolean flag = true;

        @Override
        public void run() {
            System.out.println("START RUN flagThread " + currentThread());
            int n = 0;
            while (flag) {
                n++;
            }
            System.out.println("flagThread end " + n + "次执行 " + currentThread());
        }
    }

    public static void main(String[] args) {
        System.out.println("this is main thread" + Thread.currentThread());
        // demo1
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
        //demo1中的lambda写法
        Thread thread = new Thread(() -> {
            System.out.println("new thread by lambda" + Thread.currentThread());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("new thread by lambda end" + Thread.currentThread());
        });
        thread.start();
        // demo2, 实现runnable接口把把这个类的实例化对象传入一个新的Thread类
        MyRunnable myRunnable = new MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable);
        myRunnableThread.start();

        // demo3，通过实现Callable接口


    }
}
