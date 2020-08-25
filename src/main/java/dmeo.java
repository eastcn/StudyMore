import com.east.JavaBasic.DataDemo.MapDemo;

import java.text.Collator;
import java.util.*;

/**
 * @Classname dmeo
 * @Description TODO
 * @Date 2020/8/20 2:02 下午
 * @Created by East
 */
public class dmeo {
    public String demo(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }

    static public int demo2(int x) {
        int start1 = 1, start2 = 2, sum;
        for (int i = 0; i < x; i++) {
            sum = start1 + start2;
            start1 = start2;
            start2 = sum;
        }
        return start1;
    }

    static public int demo3(int x) {
        // 1 2 3 5 8 13
        int r = 1;
        if (x > 1) {
            r = demo3(x - 1) + demo3(x - 2);
        }
        return r;
    }

    class person {
        String firstName;
        String lastName;

        public person(String f, String l) {
            firstName = f;
            lastName = l;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public void Sorted(List<person> list) {
//        LinkedList<MapDemo.User> list = new LinkedList<>();
        person user1 = new person("张", "三");
        person user2 = new person("李", "四");
        person user3 = new person("apple", "lisa");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        // TreeMap可以实现有序的数据排列，可以传入一个实现Comparable接口的类作为比较规则
        Comparator comparator = Collator.getInstance(Locale.CHINA); // 根据中文规则来进行排序
        TreeMap<String, String> treeMap = new TreeMap<>(comparator);
        for (person u : list
        ) {
            treeMap.put(u.getFirstName(), u.getLastName());
        }
        System.out.println(treeMap);

    }

    public static void main(String[] args) {
//        System.out.println(demo2(3));
        for (int i = 1; i < 10; i++) {
            System.out.println(demo3(i));
        }
    }
}
