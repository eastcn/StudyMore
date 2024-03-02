package com.east.LeetCode.Top;

/**
 * Function: 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author taihua
 * @date 2024/2/22
 */
public class Class9 {
    /**
     * 思路1：双指针遍历-超时
     * 给定两个指针i,j 代表窗口的左右边界，初始值为0,0，一个最大值的记录max=nums[i];
     * 右边界右扩，直到最后一位
     */
    public int maximumSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tempMax = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    tempMax += nums[j];
                }
                max = Math.max(tempMax, max);
            }
        }
        return max;
    }

    /**
     * 思路2 动态规划
     * 首先找状态转移方程，设一个长度为n的数组的最大子序和=f(n)
     * 那么f(n) = max(f(n-1)+nums[n], f(n-1),nums[n]);
     * 如何理解？即要知道f(n),就要知道f(n-1),f(n-1)+nums[n],nums[n]哪个更大？前两者可以合并成f(n-1)+nums[n]，因为如果f(n-1)最大那就意味nums[n]=0 +不加都可以
     * =>f(n) = max(f(n-1)+nums[n],nums[n]);
     * 边界值为 n=1, f(0) = nums[0]
     */
    public int maximumSubarray2(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];// 这个就是f(0)
        for (int n = 1; n < nums.length; n++) { // 从1开始是因为n=0的情况是已知的边界值
            tempMax = Math.max(tempMax + nums[n], nums[n]); // 这个就是f(n) = max(f(n-1)+nums[n],nums[n]);
            max = Math.max(tempMax, max);
        }
        return max;
    }

    /**
     * 贪心算法，记录一个最大和，一个当前和，
     * 当指针指向i时
     * 前面累加的和<0
     * 则g丢弃前面的累加,就，后续重新开始累加
     * >0
     * 则与最大和比较是否需要记录，并继续累加
     */
    public int maximumSubarray3(int[] nums) {
        int max = nums[0];
        int tempMax = 0;// 这个就是f(0)
        for (int x : nums) {
            if (tempMax < 0) {
                tempMax = x;
            } else {
                tempMax += x;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }

    public static void main(String[] args) {
        Class9 c = new Class9();
        System.out.println(c.maximumSubarray3(new int[]{1}));
    }
}
