package com.east.LeetCode.Problems.problem1920;

import java.util.Arrays;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/2/16
 */
public class Solution {
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }
}
