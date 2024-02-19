package com.east.LeetCode.Top;

import java.util.HashMap;

/**
 * Function: 无重复的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * @author taihua
 * @date 2024/2/19
 */
public class Class1 {
    static public int lengthOfLongestSubstring(String s) {
        /*
         * 思路1: 滑动窗口
         * 设定窗口的左右为i,j
         * 当j指向的字符与[i,j]中有重复时:
         *  记录此时子串的长度为j-i;重置左指针i的位置，为当次重复字符的索引+1(让窗口的左边界丢弃掉重复的值，重新开始新一轮的右边界后移)
         * 无重复时:
         *  此时子串的长度j-i+1;
         * 不管是否有重复,j++;
         * 当j>=s的长度时，结束循环 (所以时间复杂度为O(n))
         * 问题：
         *  如何判断字符重复=>用map
         * */
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        int l = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < chars.length) {
            char curChar = chars[j];
            int temp = map.getOrDefault(curChar, -1);
            int curLength = j - i;
            if (temp == -1 || temp < i) {
                if ((curLength + 1) > l) {
                    l = curLength + 1;
                }
            } else { // 如果有重复
                if (curLength > l) { // 判断当前子串的长度
                    l = curLength;
                }
                i = temp + 1; // 重置左指针
            }
            map.put(curChar, j); // 记录这个字符和其所在的索引
            j++; // 指针后移
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdasdasd"));
    }
}
