package com.east.LeetCode.OfferProlem;

import java.util.Arrays;

/**
 * Function: 调整数组中的奇偶数
 *
 * @author taihua
 * @date 2022/8/5
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        /*
         * 思路就是 双指针遍历; 奇数放在左边，偶数放在右边
         * */
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int temp = 0;
            while (s < e && nums[s] % 2 == 1) {
                s++;
            }
            // 如果跳出循环，则代表遇到偶数了
            temp = nums[s];
            while (s < e && nums[e] % 2 == 0) {
                e--;
            }
            // 跳出循环了则代表遇到了奇数
            nums[s] = nums[e];
            nums[e] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        Offer21 o = new Offer21();
        System.out.println(Arrays.toString(o.exchange(array)));
    }
}
