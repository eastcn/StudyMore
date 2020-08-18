package com.east.JavaBasic.MultipleThreads;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @Classname CompletableFutureDemo
 * @Description 实现一个回调函数, 不会阻塞主线程，异步返回后，会自动回调
 * @Date 2020/8/18 10:56 下午
 * @Created by East
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        // CompletableFuture.supplyAsync 构造一个CompletableFuture对象
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(new queryData());
//        completableFuture1.thenAccept(System.out::println); // 打印结果
//        completableFuture1.exceptionally((throwable -> {
//            throwable.printStackTrace();
//            return "error";
//        }));

        // 再实现一个query code的CompletableFuture对象
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(new queryCode());
//        completableFuture2.thenAccept(System.out::println); // 返回了则自动打印结果

        // 通过anyOf可以把两个CompletableFuture 做或关系判断；allOf做全逻辑判断
        CompletableFuture<Object> query1 = CompletableFuture.anyOf(completableFuture1, completableFuture2);
        CompletableFuture<Void> query2 = CompletableFuture.allOf(completableFuture1, completableFuture2);
        query1.thenAccept(System.out::println);
        query2.thenAccept(System.out::println);

        Thread.sleep(2500); // 需要等到结果返回，因此不能让主线程退出

    }

    static class queryData implements Supplier<String> {
        @Override
        public String get() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "data";
        }
    }

    static class queryCode implements Supplier<String> {
        @Override
        public String get() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "code";
        }
    }
}
