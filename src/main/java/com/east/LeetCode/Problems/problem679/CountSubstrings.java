package com.east.LeetCode.Problems.problem679;

/**
 * @Classname CountSubstrings
 * @Description TODO
 * @Date 2020/8/19 5:46 下午
 * @Created by East
 */
public class CountSubstrings {
    int num = 0;
    public int countSubstrings(String s) {
        int l = s.length();
        for (int i = 0; i < l; i++) {
            count(s, i, i + 1);
            count(s, i, i);
        }
        return num;
    }

    public void count(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            num++;
            begin--;
            end++;
        }
    }
}
