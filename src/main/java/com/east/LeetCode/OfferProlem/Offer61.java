package com.east.LeetCode.OfferProlem;

import java.util.*;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/13
 */
public class Offer61 {
    /*
     * 思路
     * 顺子牌的最大牌-最小牌==5
     * */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else {
                if (set.contains(nums[i]))
                    return false;
                set.add(nums[i]);
            }
        }
        return nums[4] - nums[zeroCount] < 5;
    }

    public static void main(String[] args) {
        Offer61 o = new Offer61();
        System.out.println(o.isStraight(new int[]{13, 13, 9, 12, 10}));
    }
}
