package com.east.JavaBasic.DataDemo;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.*;

/**
 * @Classname MapDem
 * @Description TODO
 * @Date 2020/8/13 2:49 下午
 * @Created by East
 */
public class MapDemo {
    public static void main(String[] args) {
        // map是一种 <K,V>接口的集合, HashMap是一种非线程安全的Map实现
        // map中不存在重复的K
        Map<String, String> map = new HashMap<>();
        map.put("first", "1"); // 增加一个 K,V
        System.out.println(map.get("first")); // 根据K查询V
        // 使用entry 方式遍历map，map遍历是无序的
        for (Map.Entry<String, String> map1 : map.entrySet()) {
            String k = map1.getKey();
            String v = map1.getValue();
            System.out.println(k + ":" + v);
        }
        //
        LinkedList<User> list = new LinkedList<>();
        User user1 = new User("张", "三");
        User user2 = new User("李", "四");
        User user3 = new User("apple", "lisa");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        // comparator ,可以创建一个比较方法。Java中提供了一些根据国家地区的排序方法，可用于字符串的排序。
        Comparator comparator = Collator.getInstance(Locale.CHINA); // 根据中文名来排序
        // TreeMap可以实现有序的数据排列，可以传入一个实现Comparable接口的类作为比较规则
        TreeMap<String, String> treeMap = new TreeMap<>(comparator);
        for (User u : list
        ) {
            treeMap.put(u.getFirstName(), u.getLastName());
        }
        System.out.println(treeMap);

    }

    static class User {
        String firstName;
        String lastName;

        public User(String f, String l) {
            firstName = f;
            lastName = l;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }
    }

}
