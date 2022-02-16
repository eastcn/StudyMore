package com.east.LeetCode.problem2160;

import java.util.Arrays;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/2/16
 */
public class Solution {
    public static int minimumSum(int num) {
        int[] nums = {num % 10, (num / 10) % 10, (num / 100) % 10, num / 1000};
        Arrays.sort(nums);
        return nums[0] * 10 + 10 * nums[1] + nums[2] + nums[3];
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
    }
}
