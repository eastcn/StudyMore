package com.east.LeetCode.OfferProlem;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Function: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * @author taihua
 * @date 2022/8/21
 */
public class Offer53_2 {
    /*
    思路：
    二分找一个不存在的数字，
    假设不存在的数字为x, 数组的起点和终点为s,e, 中点位置为 s+e>>>1
    根据题意可知，递增数组再没有达到缺失数字前，index=nums[index]
    所以，二分后
    如果mid==nums[mid],那么 继续对 [mid+1,e]进行二分
    如果mid<nums[mid],那么说明缺失的数字在[s, mid-1]
    直到e-s<=2时，此时数组里面要么只有e和s,此时e为替换了缺失位置的值

    这题用例其实有问题。
    如果输入[0,1]返回的是2 其实不符合题意，为了符合二分而二分
    */
    public int missingNumber(int[] nums) {
//        if (nums[0] == 0 && nums.length == 1) return 1;
//        if (nums.length == 2 && nums[1] == 1) return 2;
        int s = 0;
        int e = nums.length - 1;
        return Math.max(help(nums, s, e), 0);
    }

    public int help(int[] nums, int s, int e) {
        if (s > e)
            return s;
        int mid = e + s >>> 1;
        if (mid == nums[mid])
            return help(nums, mid + 1, e);
        else
            return help(nums, s, mid - 1);
    }

    public static void main(String[] args) {
        Offer53_2 o = new Offer53_2();
        System.out.println(o.missingNumber(new int[]{0}));
    }
}
