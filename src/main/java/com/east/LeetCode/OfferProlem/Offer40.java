package com.east.LeetCode.OfferProlem;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * Function:
 * 经典TopK
 *
 * @author taihua
 * @date 2022/8/2
 */
public class Offer40 {

    /*
     * 思路，用堆排序进行升序，然后根据k获取最小的几个值。
     * */
    public int[] getLeastNumbers(int[] arr, int k) {

        int l = arr.length;
        for (int i = l; i > k; i--) {
            getHeap(arr, i);
            int temp = arr[i - 1];
            arr[i - 1] = arr[0];
            arr[0] = temp;
        }
        int[] r = new int[k];

        return Arrays.copyOf(arr, k);
    }


    public void getHeap(int[] arr, int l) {

        int temp = 0;
        // 先把数组转化成大顶堆
        for (int i = l / 2 - 1; i >= 0; i--) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < l && arr[i] < arr[left]) {
                temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
            }
            if (right < l && arr[i] < arr[right]) {
                temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
            }

        }
    }

    // 快速排序
    public static void quickSort(int[] array, int begin, int end) {
        // 传入原始数组，以及此时要进行分治的起始位置和结束位置
        if (begin < end) {
            // 把指针指向起始位置和结束位置
            int i = begin, j = end;
            int m = array[begin]; // 作为基准值
            // 当指针未交汇时，进行循环
            while (i < j) {
                // 在保证，i<j的前提下，先将右指针左移，当遇到比m小的值时，跳出循环，否则一直左移。
                while (i < j && array[j] > m) {
                    j--;
                }
                // 跳出循环后，说明遇到了比m小的值，把当前j指向的值赋值给 i所在的值
                array[i] = array[j];
                // 在保证，i<j的前提下，再将左指针右移，当遇到比m大的值时，跳出循环，否则一直右移。
                while (i < j && array[i] <= m) {
                    i++;
                }
                // 跳出循环后，说明遇到了比m大的值，把当前i指向的值赋值给j所在的值
                array[j] = array[i];
            }
            // 跳出循环，说明此时 i = j
            array[i] = m;

            // 分完后，array[i]的左侧全是比array[i]小的值，array[i]的右侧全是比array[i]大的值
            // 因此，再对左半边和右半边进行操作。
            // 此时, 剔除i以后的，左半边的 区间为[begin, i-1],右半边区间为[i+1, end]
            quickSort(array, begin, i - 1);
            quickSort(array, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{23, 45, 17, 11, 13, 89, 72, 26, 3, 17, 11, 13};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
