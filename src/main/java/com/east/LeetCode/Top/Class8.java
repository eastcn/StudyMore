package com.east.LeetCode.Top;

import java.util.Arrays;
import java.util.Random;

/**
 * Function: 几种常见的排序算法
 *
 * @author taihua
 * @date 2024/2/21
 */
public class Class8 {
    /**
     * 1. 快速排序
     * 算法思想-分治，选择一个基准数，把在这个数组中的以这个基准数为分界
     * 大的放左边，小的放右边（降序，升序反之）
     * 然后递归处理左右两边的数组
     * <p>
     * 实现逻辑（降序为例）：
     * 实现一个分界交换的方法：
     * 确定一个基准数（随机或指定),遍历当前数组，将比基准值大的放在右边，小的放在左边，最后返回基准值的位置
     * 实现一个调用分界并递归的方法
     */
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int l, int r) {
        if (l < r) {
            int f = randomizedPartition(nums, l, r);
            sort(nums, l, f - 1); // 处理左数组
            sort(nums, f + 1, r); // 处理右数组
        }
    }

    /**
     * 方法作用：根据一个基准值，将数组分成基准值左侧都大于/小于基准值，右侧都小于/大于基准值
     * 1 设置一个基准值，放在数组最后，设置一个交换的指针，从0开始
     * 2 遍历数组，当遇到比基准值（大则降序，小则降序）的跟交换位交换，并且交换位+1
     * 3 遍历完后，将基准值填入交换位
     * 4 最后将交换位返回
     * 第2步可以优化成双指针遍历
     */
    int partition(int[] nums, int l, int r) {
        // 分区思路，记录基准值，从左到右遍历，遇到比基准值大的放在左边
        int base = nums[r]; // 设数组最后一个为基准值
        int i = l; //设置一个交换位置的索引
        for (int j = l; j < r; j++) {
            // 降序处理：遇到比基准值大的都跟交换位进行交换，然后把交换位+1
//            if (nums[j] > base) {
//                swap(nums, i, j);
//                i++;
//            }
            // 升序处理：遇到比基准小的都跟交换位进行交换，然后交换位+1，这样得到的数组在交换位左侧都比基准值小，右边都比基准值大
            if (nums[j] < base) {
                swap(nums, i, j);
                i++;
            }
        }
        // 遍历完后把交换位的最后一位跟基准值交换，这样就得到了数组，基准值左边都比基准值大，右边都比基准值小
        swap(nums, i, r);
        return i;
    }

    /**
     * 优化遍历
     * 1. 设置一个基准值放在数组最后一位
     * 2. 设置两个指针指向数组的左右边界
     * 3. 左指针遍历当遇到比基准值小的值时，跟右指针交换位置，并且右指针+1
     * 4. 然后开始执行右指针遍历，当遇到比基准值大的值时，跟左指针交换位置，并且左指针+1
     * 5. 当左右指针相遇时分区完成
     */
    public int partition2(int[] nums, int l, int r) {
        int base = nums[r];
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[i] <= base) {
                i++;
            }
            swap(nums, i, j);

            while (i < j && nums[j] >= base) {
                j--;
            }
            swap(nums, i, j);
        }
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     * 随机选点进行遍历
     * */
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition2(nums, l, r);
    }


    public static void main(String[] args) {
        int[] array = new int[]{23, 45, 17, 11, 13, 89, 72, 26, 3};

        Class8 c = new Class8();
        System.out.println(Arrays.toString(c.sortArray(array)));
    }
}
