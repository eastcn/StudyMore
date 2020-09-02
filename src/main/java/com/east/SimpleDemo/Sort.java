package com.east.SimpleDemo;

import java.util.Arrays;

/**
 * @Classname Sort
 * @Description 排序
 * @Date 2020/8/10 10:08 上午
 * @Created by East
 */
public class Sort {
    public static int[] bubbleSort(int[] array) {
        // 冒泡排序， 遍历数组第一遍获取要对比的数
        // 第二遍遍历从第一个数开始跟后面的数对比，如果比后面的大则交换位置，一直到倒数第二个
        // 这样得到的数组是从小到大的排序
        int m = array.length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }

        return array;
    }

    static public int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int x = array[low];
            int j = high;
            while (low < high) {
                while (low < high && array[j] >= x) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= x) {
                    low++;
                }
                array[high] = array[low];
            }
            x = array[low];
            // 快排
            quickSort(array, low, x - 1);
            quickSort(array, x + 1, high);
        }
        return array;
    }

    /**
     * 选择排序
     * 1. 选择数组中一个最小的值作为min，和第一位交换位置
     * 2. 每次在剩下的数中挑出最小的数字来跟当前剩下的第一位交换位置
     */
    static public int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;// 把开始的第一个值假设为最小值
            for (int j = i + 1; j < array.length; j++) { // 遍历每一轮剩下的数
                if (array[min] > array[j]) {// 如果之后有出现比之前假设为最小值的值还小的，则把这个值作为最小值。
                    min = j;
                }
            }// 这一层遍历是为了得出每一轮扫描中的最小值
            // 接下来则是把最小值和排在第一位的交换
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    static public int[] insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            // 从第2个数开始，与左边比较，如果遇到比它小的则把这个数放在这个小的数的右边
            int temp = array[i]; // 保存每次用来比较的数
            int k = i - 1; // 左边开始的第一个数的索引
            while (k >= 0 && array[i] < array[k]) { // 开始比较，索引一定要>=0，需要放在第一个判断条件，否则会数组越界
                k--; // 比较一次，没找到则再往左挪1
            }
            for (int j = i; j > k + 1; j--) { // 调整左边的数组，从比选中的数小的那个数往后的数往后挪一个位置
                array[j] = array[j - 1];
            }
            array[k + 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        System.out.println(Arrays.toString(quickSort(ns, 0, ns.length - 1)));

    }
}
