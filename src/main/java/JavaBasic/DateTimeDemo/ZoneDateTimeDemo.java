package JavaBasic.DateTimeDemo;

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
    }
}
