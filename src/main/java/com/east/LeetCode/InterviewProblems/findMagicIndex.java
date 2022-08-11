package com.east.LeetCode.InterviewProblems;

/**
 * @Classname findMagicIndex
 * @Description TODO
 * @Date 2020/7/31 10:29 上午
 * @Created by East
 */
public class findMagicIndex {
    public static int demo(int[] nums) {
        // answer1: 暴力循环
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int demo2(int[] nums) {
        // answer2: 跳跃查询,
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) {
                return i;
            } else {
                i = Math.max(i, nums[i]);
            }
        }
        return -1;
    }

    public static int demo3(int[] nums) {
        // 假二分
        return -1;
    }
}
