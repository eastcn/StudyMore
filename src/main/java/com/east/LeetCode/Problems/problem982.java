package com.east.LeetCode.Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Function: https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
 *
 * @author taihua
 * @date 2023/3/4
 */
public class problem982 {
    public static int countTriplets(int[] nums) {
        // 与运算：二进制的同一位数上都为1则取1，否则取0
        // 根据与运算特点可知，如果参与运算中的有一个值为0，那么与运算结果一定为0
        // 所以在暴力法的基础上进行循环减少
        // 当参与的有0，那么其他的两个值就是所有的组合:n*n
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();

        for (int num : set) {
            if (num == 0) {
                count = count + n * n * map.get(num);
            } else {
                for (int i : set) {
                    int ret1 = num & i;
                    if (ret1 == 0) {
                        count = count + n * map.get(i) * map.get(num);
                    } else {
                        for (int j : set) {
                            int d = num & i & j;
                            if (d == 0) {
                                count = count + map.get(j) * map.get(num) * map.get(i);
                            }
                        }
                    }
                }
            }

        }
        return count;
    }

    public static int countTriplets2(int[] nums) {
        // 思路，看题解后得
        // 先枚举前两位进行&所有可能出现的值
        // 然后记录其重复值的次数
        // 然后最后遍历一次nums和这个枚举，如果等于0那么就加
        Map<Integer, Integer> map = new HashMap<>(); // 这个长度由题干得到
        for (int i : nums) {
            for (int j : nums) {
                int r = i & j;
                if (map.containsKey(r)) {
                    map.put(r, map.get(r) + 1);
                } else {
                    map.put(r, 1);
                }
            }
        }
        int count = 0;
        // 枚举完了后遍历这个数组
        for (int k : nums) {
            for (int x : map.keySet()) {
                if ((k & x) == 0) {
                    count += map.get(x);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] x = new int[3];
        System.out.println(countTriplets2(new int[]{2,1,2,1,9}));
    }
}
