package com.east.LeetCode.Problems;

/**
 * Function: https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 *
 * @author taihua
 * @date 2023/2/27
 */
public class problem1144 {
    public static int movesToMakeZigzag(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int[] nums1 = nums.clone();
        int[] nums2 = nums.clone();
        for (int i = 0; i < nums1.length; i++) {
            boolean a = i % 2 == 0;
            // i是此时是奇数，要比左右的偶数小，否则就要操作
            if (!a) {
                if (nums1[i] >= nums1[i - 1]) {
                    count1 = count1 + nums1[i] - nums1[i - 1] + 1;
                    nums1[i] = nums1[i - 1] - 1;
                }
                if ((nums.length % 2 != 0 || i + 1 < nums1.length) && nums1[i] >= nums1[i + 1]) {
                    count1 = count1 + nums1[i] - nums1[i + 1] + 1;
                    nums1[i] = nums1[i + 1] - 1;
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            boolean a = i % 2 == 0;
            // i是此时是偶数，要比左右的奇数小，否则就要操作
            if (a) {
                if (i + 1 < nums2.length && nums2[i] >= nums2[i + 1]) {
                    count2 = count2 + nums2[i] - nums2[i + 1] + 1;
                    nums2[i] = nums2[i + 1] - 1;
                }
                if (i > 0 && nums2[i] >= nums2[i - 1]) {
                    count2 = count2 + nums2[i] - nums2[i - 1] + 1;
                    nums2[i] = nums2[i - 1] - 1;
                }
            }
        }
        return Math.min(count1, count2);
    }

    public static void main(String[] args) {
        int[] n = new int[]{7,4,8,9,7,7,5};
        System.out.println(problem1144.movesToMakeZigzag(n));
    }
}
