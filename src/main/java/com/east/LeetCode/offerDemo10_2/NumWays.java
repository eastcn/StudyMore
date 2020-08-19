package com.east.LeetCode.offerDemo10_2;

/**
 * @Classname NumWays
 * @Description TODO
 * @Date 2020/8/19 9:50 下午
 * @Created by East
 */
public class NumWays {
    /**
     * 该题可以转化为动态规划问题
     * 首先对于第n个台阶，它有f(n)种跳法，其中最后一步的跳法为1阶或者2阶，如果是1阶那么除去最后一步的跳法就是f(n-1)种跳法，如果是两步那么就是f(n-2)种跳法
     * 所以f(n+1) = f(n) + f(n-1)
     */
    static public int numWays(int n) {
        int x = 1, y = 1, z;
        for (int i = 0; i < n; i++) {
            z = (x + y);
            x = y;
            y = z;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(numWays(4));
    }
}
