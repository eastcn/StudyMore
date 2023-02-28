package com.east.LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Function: https://leetcode.cn/problems/merge-similar-items/
 *
 * @author taihua
 * @date 2023/2/28
 */
public class problem2363 {
    static class Solution {
        // 思路：
        // 1. 把二维数组转成Map, key是二维数组中的value1, value为二维数组中的value2，
        // 2. 遍历两个二维数组，key相同则累加value
        // 3. 最后把这个map转化成二维数组输出，key，value同1中一样
        // ps: treeMap 可以减少一步排序的过程
        //
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Map<Integer, Integer> treeMap = new TreeMap<>();
            setMap(items1, treeMap);
            setMap(items2, treeMap);
            List<List<Integer>> ret = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(entry.getValue());
                ret.add(list);
            }
            return ret;
        }

        public void setMap(int[][] items, Map<Integer, Integer> map) {
            for (int[] item : items) {
                map.merge(item[0], item[1], Integer::sum);
            }
        }
    }

}
