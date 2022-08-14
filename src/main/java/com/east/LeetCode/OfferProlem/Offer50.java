package com.east.LeetCode.OfferProlem;

import java.util.*;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/13
 */
public class Offer50 {
    /*
     * 双指针遍历一下
     * 用一个HashMap记录一下是否出现
     * 再用一个map记录是否只出现一次。
     * 先遍历一遍记录结果，再遍历一遍找到第一个结果
     * */
    public char firstUniqChar(String s) {
        int i = 0;
        HashMap<Character, Boolean> map1 = new HashMap<>();
        char[] chars = s.toCharArray();
        while (i <= chars.length - 1) {
            if (map1.containsKey(chars[i])) {
                map1.put(chars[i], false);
            } else {
                map1.put(chars[i], true);
            }
            i++;
        }
        for (char c : chars
        ) {
            if (map1.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        int i = 0;
        Map<Character, Boolean> map1 = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        while (i <= chars.length - 1) {
            if (map1.containsKey(chars[i])) {
                map1.put(chars[i], false);
            } else {
                map1.put(chars[i], true);
            }
            i++;
        }
        for (Map.Entry<Character, Boolean> entry : map1.entrySet()
        ) {
            if (entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }

    public char firstUniqChar3(String s) {
        int i = 0;
        Map<Character, Boolean> map1 = new HashMap<>();
        Map<Character, Boolean> map2 = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        while (i <= chars.length - 1) {
            if (map1.containsKey(chars[i])) {
                map1.put(chars[i], false);
                map2.remove(chars[i]);
            } else {
                map1.put(chars[i], true);
                map2.put(chars[i], true);
            }
            i++;
        }
        for (Map.Entry<Character, Boolean> entry : map2.entrySet()
        ) {
            if (entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }


}
