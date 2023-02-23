package com.east.LeetCode.Problems.problem1;

import java.util.HashMap;

/**
 * @Classname twoSum
 * @Description TODO
 * @Date 2020/7/9 3:46 下午
 * @Created by East
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }
        return new int[]{index1, index2};
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
