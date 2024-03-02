package com.east.LeetCode.Top;

/**
 * Function: 买入股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * @author taihua
 * @date 2024/2/24
 */
public class Class10 {
    /**
     * 思路1: 超时
     * 暴力解法双指针遍历直接找出所有组合里面后指针-前指针最大的差
     */
    public int maxProfit(int[] prices) {
        int max = 0; // 初始化为0不能获得利润
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    /**
     * 思路2
     * 贪心
     * 在第一天买入，如果后续上涨则计算是否为最大利润，如果下跌则计算是否比买入价更低，是的话修改买入价重新开始计算
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int buyIn = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 如果后续上涨则计算一下能获得的利润是多少，并看是否是最大利润
            max = Math.max(prices[i] - buyIn, max);
            // 如果下跌则看跟买入价谁更低，如果比买入价更低，则重新买入
            buyIn = Math.min(prices[i], buyIn);
        }
        return max;
    }
}
