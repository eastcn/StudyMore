package com.east.LeetCode.Top;

/**
 * Function: 合并有序数组
 *
 * @author taihua
 * @date 2024/2/24
 */
public class Class11 {
    /**
     * 思路1: 双指针遍历
     * i指向nums1,j指向nums2,再额外创建一个数组x长度为m+n
     * 同时开始遍历
     * if nums1[i]>nums2[j] j++, nums[j]放入m+n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = 0, j = 0, k = 0;
        int[] x = new int[m + n];
        while (i < m || j < n) {
            if (i == m) {
                x[k] = nums2[j];
                j++;
            } else if (j == n) {
                x[k] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                x[k] = nums2[j];
                j++;
            } else if (nums1[i] <= nums2[j]) {
                x[k] = nums1[i];
                i++;
            }
            k++;
        }
        for (int c = 0; c < m + n; c++) {
            nums1[c] = x[c];
        }
    }

    /***
     * 思路2: 不额外创建数组，直接在nums1上操作,大的放在nums1最后
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) { // nums1 先遍历完了, 那剩下的就全遍历nums2
                nums1[k] = nums2[j];
                j--;
            } else if (j < 0) { // nums2 先遍历完了, 那剩下的就全遍历nums1
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                // 如果1比2的大则1先放进数组
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] <= nums2[j]) {
                // 如果2比1的大则2先放进数组
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

}
