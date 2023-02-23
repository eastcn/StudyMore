package com.east.LeetCode.Problems.problem3;

import java.util.HashMap;
import java.util.Map;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/12/5
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int j = 0, k = 0;
        int max = 0;
        Map<Character, Integer> list = new HashMap<>();
        char[] chars = s.toCharArray();
        while (k < s.length()) {
            Integer lastPos = list.getOrDefault(chars[k], -1);
            if (lastPos == -1) {
                // 无重复
                list.put(chars[k], k);
                k++;
            } else {
                // 有重复，判断当前的记录的子串是否跟max的大小比
                // 再获取重复的位置，这次的窗口从重复的位置+1开始计算
                max = Math.max(list.keySet().size(), max);
                list = new HashMap<>();
                j = lastPos + 1;
                k = j;
            }
        }
        max = Math.max(list.keySet().size(), max);
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int j = 0, k = 0;
        int max = 0;
        Map<Character, Integer> list = new HashMap<>();
        char[] chars = s.toCharArray();
        while (k < s.length()) {
            Integer lastPos = list.getOrDefault(chars[k], -1);
            if (lastPos < j) {
                // 无重复
                list.put(chars[k], k);
                k++;
            } else {
                // 有重复，判断当前的记录的子串是否跟max的大小比
                // 再获取重复的位置，这次的窗口从重复的位置+1开始计算
                max = Math.max(k - j, max);
                j = lastPos + 1;
//                k = j;
            }
        }
        max = Math.max(k - j, max);
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int j = 0;
        int max = 0;
        Map<Character, Integer> list = new HashMap<>();
        int i = 0;
        for (; i < s.length(); ++i) {
            char c = s.charAt(i);
            Integer lastPos = list.getOrDefault(s.charAt(i), -1);
            if (lastPos >= j) {
                // 有重复，判断当前的记录的子串是否跟max的大小比
                // 再获取重复的位置，这次的窗口从重复的位置+1开始计算
                max = Math.max(i - j, max);
                j = lastPos + 1;
            }
            list.put(c, i);
        }
        max = Math.max(i - j, max);
        return max;
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring3(a));
    }
}
