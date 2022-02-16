package com.east.LeetCode.problem724;

import java.util.Arrays;

/**
 * Function: 查找数组中心下表
 *
 * @author east
 * @date 2022/2/16
 */
public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                sumRight += nums[j];
            }
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }
    /*
     * 先计算出整个数组的total
     * 记中心下标为i
     * 条件为左边的和等于右边的和 =>
     * sumLeft = sum_i
     * sumRight = total - sum_i - num[i]
     * sumLeft = sumRight
     *  => sum_i = total - sum_i - num[i]
     *  => sum_i * 2 = total - num[i]
     * */

    public static int pivotIndexLeetCode(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum_i = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum_i + nums[i] == total) {
                return i;
            }
            sum_i += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(pivotIndex(nums));
    }
}
