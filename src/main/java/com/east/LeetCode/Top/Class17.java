package com.east.LeetCode.Top;

import java.util.Arrays;

/**
 * Function: 最大数
 *
 * @author taihua
 * @date 2024/2/29
 */
public class Class17 {
    /*
     * 思路1：
     * 对数组中的元素两两排序，x和y是xy排列大还是yx大
     * */
    public String largestNumber(int[] nums) {
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array, (x, y) -> {
            // 比较是 xy排列大还是yx排列大
            String sx = String.valueOf(x);
            String sy = String.valueOf(y);
            String xy = sx+sy;
            String yx = sy+sx;
            return yx.compareTo(xy);
        });
        if (array[0] == 0) {
            // 特殊情况，如果首位是0，代表后面全是0，那就直接返回0
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : array) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Class17().largestNumber(new int[]{3,30,34,5,9}));
    }
}
