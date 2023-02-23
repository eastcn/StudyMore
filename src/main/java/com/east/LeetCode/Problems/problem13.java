package com.east.LeetCode.Problems;

import java.util.HashMap;

/**
 * Function: 罗马数字转阿拉伯数字[easy]
 *
 * @author taihua
 * @date 2023/2/23
 */
public class problem13 {
    static class Solution {
        static public int romanToInt(String s) {
            // 思路：
            // 用一个map先记录最基本的词表
            // 先实现通常情况，处理特殊情况
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            char[] chars = s.toCharArray();
            int total = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int count;
                if (c == 'I') {
                    if (i + 1 < chars.length && chars[i + 1] == 'V') {
                        count = 4;
                        i = i + 1;
                    } else if (i + 1 < chars.length && chars[i + 1] == 'X') {
                        count = 9;
                        i = i + 1;
                    } else {
                        count = 1;
                    }
                } else if (c == 'X') {
                    if (i + 1 < chars.length && chars[i + 1] == 'L') {
                        count = 40;
                        i = i + 1;
                    } else if (i + 1 < chars.length && chars[i + 1] == 'C') {
                        count = 90;
                        i = i + 1;
                    } else {
                        count = 1;
                    }
                } else if (c == 'C') {
                    if (i + 1 < chars.length && chars[i + 1] == 'D') {
                        count = 400;
                        i = i + 1;
                    } else if (i + 1 < chars.length && chars[i + 1] == 'M') {
                        count = 900;
                        i = i + 1;
                    } else {
                        count = 1;
                    }
                } else {
                    count = map.get(c);
                }
                total += count;
            }
            return total;
        }

        static public int romanToInt2(String s) {
            // 思路：
            // 用一个map先记录最基本的词表
            // 先实现通常情况，处理特殊情况
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            char[] chars = s.toCharArray();
            int total = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int x = map.get(c);
                int count;
                // 如果后面的值比前面的大并且前面的值为 IXC，这两个组合就等于后面的值-前面的值
                if (i + 1 < chars.length && map.get(chars[i + 1]) > x
                        && (c == 'I' || c == 'X' || c == 'C')) {
                    count = map.get(chars[i + 1]) - x;
                    i = i + 1;
                } else {
                    count = x;
                }
                total += count;
            }
            return total;
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution.romanToInt2("MCMXCIV"));

    }
}
