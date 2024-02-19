package com.east.LeetCode.Problems;

/**
 * Function:
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 *
 * @author taihua
 * @date 2023/3/5
 */
public class problem1599 {
    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // 思路： 统计当前等待的人数，和当前摩天轮四个位置的人数
        int waitPersons = 0;
        // int[] sits = new int[4];
        int onSit = 0;
        int earnMoney = 0;
        int[] maxMoney = new int[2];
        int runTimes = 0;
        for (int i = 0; i < customers.length; i++) {
            runTimes = i + 1;
            waitPersons += customers[i];
            if (waitPersons <= 4) {
                onSit += waitPersons;
                waitPersons = 0;
            } else {
                onSit += 4;
                waitPersons -= 4;
            }
            earnMoney = onSit * boardingCost - runTimes * runningCost;
            if (earnMoney > maxMoney[0]) {
                maxMoney[0] = earnMoney;
                maxMoney[1] = runTimes;
            }
        }
        while (waitPersons > 0) {
            runTimes++;
            if (waitPersons <= 4) {
                onSit += waitPersons;
                waitPersons = 0;
            } else {
                onSit += 4;
                waitPersons -= 4;
            }
            earnMoney = onSit * boardingCost - runTimes * runningCost;
            if (earnMoney > maxMoney[0]) {
                maxMoney[0] = earnMoney;
                maxMoney[1] = runTimes;
            }
        }
        return maxMoney[1] == 0 ? -1 : maxMoney[1];
    }

    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{3,4,0,5,1}, 1, 92));
    }
}
