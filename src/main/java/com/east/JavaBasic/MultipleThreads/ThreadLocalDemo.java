package com.east.JavaBasic.MultipleThreads;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Classname TreadLocalDemo
 * @Description ThreadLocal 是一个帮助在线程中传递参数的类
 * 该类可以把一个上下文传入线程，当前线程通过使用ThreadLocal的对象.get()来获取上下文
 * 可以理解为，ThreadLocal创建了一个 属于这个线程的局部变量，因为其他线程来取这个值的时候获取到是不同的实例对象
 * @Date 2020/8/20 11:54 下午
 * @Created by East
 */
public class ThreadLocalDemo {
    static class context {
        public String name;

        context(String x) {
            name = x;
        }
    }

    static final ThreadLocal<context> ctx = new ThreadLocal<>();

    static public void doSomething() {
        // IntStream.range(start,end)，方法可以创造 从start-end的数组，类似python的range
        IntStream.range(0, 5).forEach(x -> { // 流式 forEach，创建5个线程。
            new Thread(() -> { // lambda表达式
                context c = new context("context " + x); //
                ctx.set(c);// 实例化一个context对象设置为ThreadLocal的内容
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + ctx.get().name); // 通过get去取当前TreadLocal的内容
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ctx.remove(); // 释放
                }
            }).start();
        });
    }

    public void doThings(context c) {
        System.out.println(c.name);
    }

    public static void main(String[] args) {
        doSomething();
    }

}
