package com.east.LeetCode.Top;

import java.util.*;

/**
 * Function: 三数之和
 * https://leetcode.cn/problems/3sum/
 *
 * @author taihua
 * @date 2024/2/21
 */
public class Class7 {
    /**
     * 思路1： 暴力解法，会超时
     * 三指针遍历，判断是否符合条件并且去重
     * 如何去重：
     * 1. 排序后组成字符串存入map
     * <p>
     * 思路2：从和为0切入
     * a+b+c=0 => a = -b-c
     * 所以当确定a后，去找是否有符合条件的b和c
     * 而a的情况又可以特化为a=0 和a!=0
     * 当a=0的时候，只要b=-c或者-b=c就可以
     * 当a!=0的时候，需要判断a = -b-c
     * 先遍历一遍数组转化成一个初始化的map
     * 再双指针遍历数组得到a+b，并判断-c在map中是否存在，存在则成立不存在则不成立
     * <p>
     * 思路3：对整个数组先排序，然后在遍历的时候跳过重复的值
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<List<Integer>, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && i != k && j != k) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            Collections.sort(list);
                            if (!map.containsKey(list)) {
                                map.put(list, true);
                                res.add(list);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).put(i, true);
            } else {
                HashMap<Integer, Boolean> m = new HashMap<>();
                m.put(i, true);
                map.put(nums[i], m);
            }
        }
        HashMap<List<Integer>, Boolean> tempMap = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            for (int k = 0; k < nums.length; k++) {
                if (k != j) {
                    int c = nums[j] + nums[k];
                    if (map.containsKey(-c)) {
                        if ((!map.get(-c).containsKey(j) && !map.get(-c).containsKey(k)) || map.get(-c).size() > 2) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(-c);
                            Collections.sort(list);
                            if (!tempMap.containsKey(list)) {
                                tempMap.put(list, true);
                                res.add(list);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length; i++) {
            // a需要遍历
            if (i == 0 || nums[i] != nums[i - 1]) {
                // 防止重复计算，所以当a跟上一次不一样的时候才开始计算
                // 双指针遍历全部的数组
                int k = nums.length - 1; // 记录c的位置
                for (int j = i + 1; j < k; j++) {
                    // 左指针从左到右，右指针从右到左
                    if (j == i + 1 || nums[j] != nums[j - 1]) {// b也需要防止重复计算，所以也是当在第一位和当前位与前位不同时才计算
                        while (k > j && nums[j] + nums[k] + nums[i] > 0) {//如果加起来>0那右指针就一直左移动
                            k--;
                        }
                        if (j == k) { // 当右指针等于左指针时，循环结束
                            break;
                        }
                        if (nums[i] + nums[j] + nums[k] == 0) { // 当和符合条件时记录
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Class7 c = new Class7();
        System.out.println(c.threeSum3(new int[]{-1, 0, 1, 2, -1, -4, -1, -4}));
    }
}
