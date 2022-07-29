package com.east.LeetCode.OfferProlem;

/**
 * Function:
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author taihua
 * @date 2022/7/30
 */
public class Offer10 {
    /**
     * 动态规划
     * 每次青蛙可以选择跳1个台阶或者2个台阶。
     * 可知，要跳上第N个台阶时，青蛙的最后一跳有两种可能，
     * 1. 在第N-1个台阶上，跳1个台阶。
     * 2. 在第N-2个台阶上，跳2个台阶。
     * 所以，第N个台阶的可能性就是 青蛙跳到第N-1和N-2的台阶的和。
     * 如果用：
     * f(n) = 青蛙跳上第n个台阶的情况
     * f(n-1) = 青蛙跳上第n-1个台阶的情况
     * f(n-2) = 青蛙跳上第n-2个台阶的情况
     * 那么得到动态规划的状态转移方程为： f(n) = f(n-1) + f(n-2),极限情况为 f(2) = f(1) + f(0)
     * 同 斐波那契数列的解法一样。有两种，递归和循环。
     */
    public int numWays(int n) {
        // 递归, 会超时
        int mod = 1000000007;
        if (n == 0) {
            return 1;
        } else if (n <= 2)
            return n;
        else {
            return (numWays(n - 1) + numWays(n - 2)) % mod;
        }
    }

    public int numWays2(int n) {
        // 循环
        int mod = 1000000007;
        if (n == 0) {
            return 1;
        } else if (n < 2)
            return n;
        else {
            int fn_1 = 1; // f(1) = 1;
            int fn_2 = 1; // f(0) = 1; maybe是为了计算
            int fn = 0; // 初始化，等于多少不重要
            for (int i = 2; i <= n; i++) {
                fn = (fn_1 + fn_2) % mod;
                fn_2 = fn_1;
                fn_1 = fn;
            }
            return fn;
        }
    }

    public static void main(String[] args) {
        System.out.println((4 + 2) >>> 1);
    }

}
