package com.east.LeetCode.Top;

import java.util.HashMap;

/**
 * Function: 多数元素
 *
 * @author taihua
 * @date 2024/2/26
 */
public class Class14 {
    /*
     * 思路1：遍历一次，用map记录数字出现的次数
     * */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x)) {
                int count = map.get(x);
                map.put(x, count + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int k : map.keySet()) {
            if (map.get(k) > nums.length / 2) {
                return k;
            }
        }
        return 0;
    }

    /*
     * 思路2：减少一次循环
     * */
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x)) {
                int count = map.get(x) + 1;
                if (count > nums.length / 2) {
                    return x;
                }
                map.put(x, count);
            } else {
                map.put(x, 1);
            }
        }
        return nums[0];
    }

    /*
     * 思路3： 双指针遍历
     * */
    public int majorityElement3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int x = nums[left];
            if (map.containsKey(x)) {
                int count = map.get(x) + 1;
                if (count > nums.length / 2) {
                    return x;
                }
                map.put(x, count);
            } else {
                map.put(x, 1);
            }
            left++;
            int y = nums[right];
            if (map.containsKey(y)) {
                int count = map.get(y) + 1;
                if (count > nums.length / 2) {
                    return y;
                }
                map.put(y, count);
            } else {
                map.put(y, 1);
            }
            right--;
        }
        return nums[0];
    }

    /*
     * 思路4： 摩尔投票
     * 数学原理: 众数与非众数的消除，最后留下来的一定是众数
     * 实现：定义一个total，以及定义第一个是众数，后续出现一样的数字时++，不一样时--，当total=0时，重新循环，剩下来的众数就是要求的。
     * */
    public int majorityElement4(int[] nums) {
        int total = 0, mo = nums[0];
        for (int n : nums) {
            if (total == 0) mo = n;
            if (mo == n) total++;
            else total--;
        }
        return mo;
    }

    public static void main(String[] args) {
        System.out.println(new Class14().majorityElement4(new int[]{3, 2, 3}));
    }
}
