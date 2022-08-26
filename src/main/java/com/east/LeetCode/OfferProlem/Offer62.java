package com.east.LeetCode.OfferProlem;

/**
 * Function: 圆圈中最后剩下的数字
 *
 * @author taihua
 * @date 2022/8/15
 */
public class Offer62 {
    /*
     * 思路，每次隔m个数剔除一次，求最后剩下的那个数
     * 动态规划，假设每一轮要剔除的数为 f(n)
     * 那么减去1个值以后结果是 f(n-1)
     * 到最后要 f(0)的结果就是要求的那个数
     *
     * f(n) = (f(n-1) + m) % n;
     * */
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
