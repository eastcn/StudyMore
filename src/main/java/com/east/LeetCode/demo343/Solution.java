package com.east.LeetCode.demo343;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2020/7/30 4:48 下午
 * @Created by East
 */
public class Solution {
    public static int integerBreak(int n) {
        // 数学解法： 题目可以拆解为 f(x) = x^(n/x), 对其求导可以发现其最大值出现在 x=e
//        System.out.println(4 * 4 * 4 * 4 * 4);
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int a = 1;
        while (n > 4) {
            n = n - 3;
            a = a * 3;
        }
        return a * n;
    }
}
