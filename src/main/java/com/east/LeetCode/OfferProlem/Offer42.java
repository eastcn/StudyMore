package com.east.LeetCode.OfferProlem;

/**
 * Function:
 * 连续子数组的最大和
 *
 * @author taihua
 * @date 2022/8/17
 */
public class Offer42 {
    /*
     * 思路：
     * 动态规划
     * 假设 f(n) = 当以nums[n]为结尾的的数组的和最大
     * 那么 f(n) = f(n-1)+nums[i]
     * 但是由于 f(n-1) 有可能为负数, 那么此时f(n-1) + nums[n]必然小于nums[n],那么可以舍弃f(n-1)，重新开始计算
     * 得到转移方程为
     * 如果f(n-1) >0 f(n) = f(n-1) + nums[i]
     * 如果f(n-1) <=0 f(n) = nums[i]
     * 极限情况
     * f(0) = nums[0]
     * */
    public int maxSubArray(int[] nums) {
        int max = nums[0]; // 记录最大值
        int f = nums[0];
        int f_1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (f_1 > 0) {
                f = f_1 + nums[i];
            } else {
                f = nums[i];
            }
            if (f > max) {
                max = f;
            }
            f_1 = f;

        }
        return max;
    }

    // 思路2 暴力法

}
