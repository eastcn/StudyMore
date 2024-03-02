package com.east.LeetCode.SortClass;

import com.east.LeetCode.Top.Class16;

/**
 * Function: 堆排序
 *
 * @author taihua
 * @date 2024/2/28
 */
public class heapSort {
    /*
     * 思路1：
     * 堆排序
     * */
    public int findKthLargest(int[] nums, int k) {
        // 构建堆
        buildMaxHeap(nums, nums.length);
        // 交换数据,交换到第k个时就是第k大的数据
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            buildMaxHeap(nums, i);
        }
        return nums[nums.length - k];
    }

    // 构建大顶堆，升序
    public void buildMaxHeap(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            int largest = i;
            int l = 2 * i + 1;
            int r = l + 1;
            if (l < length && nums[largest] < nums[l]) {
                largest = l;
            }
            if (r < length && nums[largest] < nums[r]) {
                largest = r;
            }
            if (largest != i) {
                swap(nums, i, largest);
            }
        }
    }

    // 构建小顶堆,降序
    public void buildMinHeap(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            int min = i;
            int l = 2 * i + 1;
            int r = l + 1;
            if (l < length && nums[min] > nums[l]) {
                min = l;
            }
            if (r < length && nums[min] > nums[r]) {
                min = r;
            }
            if (min != i) {
                swap(nums, i, min);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new heapSort().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
