package com.east.LeetCode.demo17_13;

/**
 * @Classname respace
 * @Description TODO
 * @Date 2020/7/9 10:47 上午
 * @Created by East
 */
public class Respace {
    /*
    * 根据字典中的单词的长度去匹配sentence中是否有匹配的数字
    * 动态规划算法：
    *   1. 状态转换 dp[i] 代表前i个字符中不匹配的字符数,
    * */
    public int respace(String[] dictionary, String sentence) {
        int dictLen = dictionary.length;
        int senLen = sentence.length();

        int[] dp = new int[senLen + 1];
        for (int i = 1; i <= senLen; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < dictLen; j++) {
                int wordLen = dictionary[j].length();
                if (wordLen <= i) {
                    if (sentence.substring(i - wordLen, i).equals(dictionary[j])) {
                        dp[i] = Math.max(dp[i], dp[i - wordLen] + wordLen);
                    }
                }
            }
        }
        return senLen - dp[senLen];
    }

    public int respace2(String[] dictionary, String sentence) {
        int senLen = sentence.length();

        int[] dp = new int[senLen + 1];
        for (int i = 1; i <= senLen; i++) {
            dp[i] = dp[i - 1] + 1;
            for (String s : dictionary) {
                int wordLen = s.length();
                if (i >= wordLen) {
                    if (sentence.substring(i - wordLen, i).equals(s)) {
                        dp[i] = Math.min(dp[i], dp[i - wordLen]);
                    }
                }
            }
        }
        return dp[senLen];
    }
}
