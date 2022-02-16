package com.east.LeetCode.problem491;

import java.util.*;

/**
 * @Classname FindSubsequences
 * @Description TODO
 * @Date 2020/8/25 5:48 下午
 * @Created by East
 */
public class FindSubsequences {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> f = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        // 递归，深度优先搜素，选定一个初始值，不断往后搜索
        // 使用一个set来保存
        // 搜索完一轮，初始值设置为另一个值
        Arrays.sort(nums);
        return f;
    }

    public void getSubList(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                f.add(temp);
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            getSubList(cur + 1, nums[cur], nums);
        }
        if (nums[cur] != last) {
            getSubList(cur + 1, last, nums);
        }
    }
}
