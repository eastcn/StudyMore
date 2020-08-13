package SimpleDemo;

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

    public static void main(String[] args) {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        System.out.println(Arrays.toString(bubbleSort(ns)));

    }
}
