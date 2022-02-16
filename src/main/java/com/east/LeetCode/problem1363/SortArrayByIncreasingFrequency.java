package com.east.LeetCode.problem1363;

import java.util.HashMap;
import java.util.Map;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/2/16
 */
public class SortArrayByIncreasingFrequency {
    public void frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] keyNums = new int[map.size()];
        for (int i = 0; i < map.size(); i++) {
            // 根据频率排序
        }
        // 重新构造新数组

    }
}
