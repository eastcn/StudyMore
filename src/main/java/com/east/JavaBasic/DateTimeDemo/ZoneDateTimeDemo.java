package com.east.JavaBasic.DateTimeDemo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Classname ZoneDateTime
 * @Description 加时区的时间
 * @Date 2020/8/15 12:50 上午
 * @Created by East
 */
public class ZoneDateTimeDemo {
    public static void main(String[] args) {
        // 带时区的时间格式
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        // 指定时区
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
        // 给LocalDateTime加上ZoneId就会变成ZoneDateTime
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("当前默认时区：" + dt.atZone(ZoneId.systemDefault()));
        System.out.println("纽约时区的时间：" + dt.atZone(ZoneId.of("America/New_York")));
        // 时区转化
        System.out.println("转换后的时间：" + zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York")));
    }
}
