package com.east.LeetCode.Top;

import com.east.LeetCode.SortClass.heapSort;

/**
 * Function: 第K大的数
 *
 * @author taihua
 * @date 2024/2/28
 */
public class Class16 {
    /*
     * 思路1：
     * 堆排序变种，维护一个k大的小根堆数组，遍历原数组，
     * 如果比当前小根堆堆顶的值大时，替换堆顶元素，并重新构建小根堆
     * 这样得到的小根堆永远一直都是遍历完数组的K大，堆顶即为第k大的元素
     * */
    public int findKthLargest(int[] nums, int k) {
        int[] miniHeadArray = new int[k];
        for (int i = 0; i < k; i++) {
            miniHeadArray[i] = nums[i];
        }
        buildMiniHeap(miniHeadArray); //得到一个小根堆，堆顶的数是数组里面最小
        for (int i = k; i < nums.length; i++) {
            // 如果比堆顶的大则跟堆顶交换，并重新构建堆
            if (nums[i] > miniHeadArray[0]) {
                miniHeadArray[0] = nums[i];
                buildMiniHeap(miniHeadArray);
            }
        }
        return miniHeadArray[0];
    }

    public void buildMiniHeap(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int min = i, l = 2 * i + 1, r = l + 1;
            if (l < n && array[l] < array[min]) {
                min = l;
            }
            if (r < n && array[r] < array[min]) {
                min = r;
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    /*
     * 思路2：
     * 大根堆排序，在交换位置时只换k-1次,k-1次交换完后，第k大的数就在数组[0]的位置
     * */
    public int findKthLargest1(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, nums.length);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            heapBuild(nums, 0, --heapSize);
        }
        return nums[0]; // 这样少遍历一次
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapBuild(nums, i, heapSize);
        }
    }

    /*
     *
     *
     * 具体思路是：从堆的最小非叶子节点开始向上遍历，最小的非叶子节点为 n/2 - 1
     * 向上遍历的时候，判断当前节点是否为大根堆的父节点，如果不是的话，跟父节点换位置
     */
    public void heapBuild(int[] array, int curIndex, int heapSize) {
        int max = curIndex; // 假设当前索引指向的为最大值
        int l = curIndex * 2 + 1, r = l + 1;
        if (l < heapSize && array[l] > array[max]) {
            // 如果左子节点比max的大
            max = l;
        }
        if (r < heapSize && array[r] > array[max]) {
            // 如果右子节点比max的大
            max = r;
        }
        if (max != curIndex) {
            // 最后判断一下是否发生变化，变化了则交换一下索引指向的数据
            swap(array, max, curIndex);
            heapBuild(array, max, heapSize);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Class16().findKthLargest1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
