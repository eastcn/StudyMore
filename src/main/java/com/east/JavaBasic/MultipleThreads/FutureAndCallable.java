package com.east.JavaBasic.MultipleThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname FutureAndCallable
 * @Description Future和Callable Demo
 * @Date 2020/8/18 10:33 下午
 * @Created by East
 */
public class FutureAndCallable {
    /**
     * Callable接口允许指定泛型返回值
     */
    static class Task implements Callable<String> { //指定泛型 为call方法的返回值
        public String name;

        public Task(String n) {
            this.name = n;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            return name;
        }
    }

    /**
     * ExecutorService 中submit方法返回的是一个Future对象
     * Future接口的可以通过get方法获取异步的返回结果
     * 当异步内容完成时，get方法会立刻返回，如果没有完成则会一直阻塞
     * 可以指定等待时间
     * isDone
     * cancel
     * isCancelled
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>(); // Future指定的泛型为返回值的类型
        for (int i = 0; i < 5; i++) {
            Future<String> future = es.submit(new Task("Task" + i));
            futures.add(future);
        }
        for (Future<String> future : futures
        ) {
            System.out.println(future.get());
//            future.get(1,TimeUnit.SECONDS); //指定等待时间，抛出超时异常
//            future.cancel(true); // 取消当前任务
//            future.isDone(); // 判断是否完成
//            future.isCancelled(); // 判断是否被取消
        }
        es.shutdown();
    }
}
