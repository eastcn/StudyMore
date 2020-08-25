package com.east.JavaBasic.MultipleThreads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname ConcurrentDemo
 * @Description Concurrent提供了一些线程安全的集合
 * 1、ConcurrentHashMap
 * 2、CopyOnWriteArrayList
 * 3、CopyOnWriteArraySet
 * 4、ArrayBlockingQueue/LinkedBlockingQueue
 * 5、LinkedBlockingDeque
 * 只需要在多线程时实现接口类时 用这些替换即可
 * @Date 2020/8/18 8:49 下午
 * @Created by East
 */
public class ConcurrentDemo {
    /**
     * 1、ConcurrentHashMap
     * 2、CopyOnWriteArrayList
     * 3、CopyOnWriteArraySet
     * 4、ArrayBlockingQueue/LinkedBlockingQueue
     * 5、LinkedBlockingDeque
     * <p>
     * 还提供了Atomic，是java提供的一些原子性操作的类库
     */
    public static void main(String[] args) {
        System.out.println("1");
        int integer = 0;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "2");
        System.out.println(concurrentHashMap.get("1"));
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.addAndGet(1)); // 增加并返回
    }
}
