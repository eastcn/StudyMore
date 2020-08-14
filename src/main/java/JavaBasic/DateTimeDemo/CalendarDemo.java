package JavaBasic.DateTimeDemo;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @Classname Date
 * @Description TODO
 * @Date 2020/8/14 3:12 下午
 * @Created by East
 */
public class CalendarDemo {
    public static void main(String[] args) {
        // 通过 Calendar.getInstance创建对象
        Calendar calendar = Calendar.getInstance();
        // 获取年
        System.out.println(calendar.get(Calendar.YEAR));
        // 月
        System.out.println(calendar.get(Calendar.MONTH));
        // 日
        System.out.println(calendar.get(Calendar.DATE));
        // 日
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // 周
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        // 当前时间 具体到秒
        System.out.println(calendar.getTime());
        // TimeZone 获取当前时区
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("当前时区：" + timeZone);
        // 获取其他时区
        System.out.println(TimeZone.getTimeZone("America/New_York"));
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        // 根据时区来设置转化时间
        TimeZone timeNewYork = TimeZone.getTimeZone("Africa/Abidjan");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("本地当前时间：" + sdf.format(calendar.getTime()));
        calendar.setTimeZone(timeNewYork);
        // 修改时区后只用使用getTime方法 获取到的时间仍为当前时区的时间,因为Calendar在实例化出来后时间就固定了
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println( sdf.format(calendar.getTime()));
        // 把现有的时间转化成其他时区的时间
        Calendar calendar1 = Calendar.getInstance();
        calendar1.clear(); // 清空当前对象的数据
        calendar1.set(2020, Calendar.SEPTEMBER, 14, 17, 45);
        sdf.setTimeZone(timeNewYork);
        System.out.println("纽约时间：" + sdf.format(calendar1.getTime()));
    }
}
