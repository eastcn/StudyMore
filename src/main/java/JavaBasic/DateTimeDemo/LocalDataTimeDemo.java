package JavaBasic.DateTimeDemo;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Classname LocalDataTimeDemo
 * @Description 新API 用于代替Date
 * @Date 2020/8/14 6:00 下午
 * @Created by East
 */
public class LocalDataTimeDemo {
    public static void main(String[] args) {
        // 当前日期 按当前时区
        LocalDate d = LocalDate.now();
        System.out.println("当前时间：" + d);
        // 当前时间 按当前时区
        LocalTime t = LocalTime.now();
        System.out.println("当前时间:" + t);
        // 当前日期和时间 按当前时区
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("当前日期和时间:" + dt);
        // 日期和时间之间的转化
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDate d1 = dt1.toLocalDate();
        LocalTime t1 = dt1.toLocalTime();
        // 把LocalDateTime转为自定义格式;把其他格式的时间转化为LocalDateTime
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dft.format(dt1));
        LocalDateTime dt2 = LocalDateTime.parse("2020/08/14 00:01:12", dft);
        System.out.println(dt2);
        // 时间加减
        LocalDateTime dt3 = dt1.minusDays(1).plusDays(1).plusYears(1);
        System.out.println(dt3);
        // 两个时间之间的间隔 duration, 把时间格式转化为DateTime就可以做
        Duration duration = Duration.between(dt1, dt3);
        System.out.println(duration);
        // 两个LocalDte之间的差值用Period表示
        Period period = d1.plusDays(1).until(d);
        System.out.println(period);
    }
}
