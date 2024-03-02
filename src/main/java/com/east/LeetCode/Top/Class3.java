package com.east.LeetCode.Top;

/**
 * Function: 两数之和
 *
 * @author taihua
 * @date 2024/2/20
 */
public class Class3 {
    public int[] twoSum(int[] nums, int target) {
        /*
        思路1，循环两次，先循环确定一个值，再循环确定另一个
        */
        int[] res = new int[2];
        boolean f = false;
        for (int i = 0; i < nums.length; i++) {
            int o = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (o == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    f = true;
                    break;
                }
            }
            if (f) {
                break;
            }
        }
        return res;
    }
}
