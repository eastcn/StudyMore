package com.east.LeetCode.offerProblem3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FindRepeatNumber
 * @Description TODO
 * @Date 2020/8/19 6:10 下午
 * @Created by East
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int x= 0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(map.get(1));
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                x=nums[i];
                break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        System.out.println(findRepeatNumber.findRepeatNumber2(new int[]{1, 2, 3, 3, 4, 4, 4, 422}));
    }
}
