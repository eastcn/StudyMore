package com.east.JavaBasic.DateTimeDemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Classname DateTimeFormatterDemo
 * @Description 用于代替旧api中的SimpleDateFormatter
 * @Date 2020/8/15 10:21 上午
 * @Created by East
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        // DateTimeFormatter 是线程安全的,可以创建一个实例后不断的调用
        // ofPattern 可以指定以某个国家的默认方式来展示
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(dtf.format(ldt));

    }
}
