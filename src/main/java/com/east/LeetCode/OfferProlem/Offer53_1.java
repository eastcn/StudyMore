package com.east.LeetCode.OfferProlem;

/**
 * Function: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author taihua
 * @date 2022/8/20
 */
public class Offer53_1 {
    /*
     * 思路
     * 二分查找
     * 数组长度为l, 数组起点为s,末尾为e
     * 中位数为 mid = e-s/2
     * 如果 target<nums[mid]，则将nums[s,mid-1]作为输入，进行递归
     * 如果 target>nums[mid], 则将nums[mid+1,e]作为输入，进行递归
     * 如果 target == nums[mid]， count +1,并将左右分别输入进行递归
     * 数组长度为1时作为退出条件
     * */
    private int[] nums;
    private int count = 0;

    public int search(int[] nums, int target) {
        if (nums.length==0) return 0;
        this.nums = nums;
        countTarget(target, 0, nums.length - 1);
        return this.count;
    }

    public void countTarget(int target, int s, int e) {
        if (s > e) return;
        int mid = (e + s) / 2;
        if (target > nums[mid]) {
            countTarget(target, mid + 1, e);
        } else if (target < nums[mid]) {
            countTarget(target, s, mid - 1);
        } else {
            count++;
            countTarget(target, mid + 1, e);
            countTarget(target, s, mid - 1);
        }

    }

    public static void main(String[] args) {
        Offer53_1 o = new Offer53_1();
        System.out.println(o.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
