package com.east.JavaBasic.DataDemo;

import java.util.HashMap;
import java.util.Map;

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
    }
}
