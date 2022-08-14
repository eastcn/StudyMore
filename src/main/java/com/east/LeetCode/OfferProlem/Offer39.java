package com.east.LeetCode.OfferProlem;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/14
 */
public class Offer39 {
    /*
     * 1. 直接暴力法
     * 遍历一遍，用hashmap把每个数字的次数记下来，然后遍历map找那个次数最多的
     * */
    /*
     * 2. 排序
     * 将数组排序，最中间的值一定是那个值
     * */
    /*
     * 3. 摩尔投票法，用于找众数
     * 基于两个推论：
     * 1. 众数投票为+1，非众数投票为-1，那么整个数组的投票值一定大于0
     * 2. 如果数组前a个值的投票数为0，那么后n-a个数的投票也一定大于0
     * 所以思路如下：
     * 遍历数组，初始投票值（vote）为0，假设众数为0。
     * 那么，遇到第n个值的时候判断，
     * 此时vote是否为0，如果是0，那么把第n个值当做众数，vote +1
     * 如果vote不为0，再判断该值是否跟此时众数相等
     * 如果相等，那么 vote + 1，不相等那么vote - 1
     *
     * 遍历到最后时返回此时的众数值
     * */
    public int majorityElement(int[] nums) {
        int vote = 0, majorNum = 0;
        for (int num : nums) {
            majorNum = vote == 0 ? num : majorNum;
            if (majorNum == num)
                vote = vote + 1;
            else
                vote = vote - 1;
        }
        return majorNum;
    }

}
