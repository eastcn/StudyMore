package com.east.LeetCode.OfferProlem;

import java.util.Arrays;

/**
 * Function: 顺时针打印矩阵
 *
 * @author taihua
 * @date 2022/8/7
 */
public class Offer29 {
    public int l1, l2, count, direction;
    int[] array;
    boolean[][] visited;

    /*
     * 思路1:
     * 定义一个方向 direction 变量，用于表示当前前进的方向
     * 定义i、j用于表示二维数组的扫描下标
     * 定义二维数组用于记录是否已经走过该位置
     * 定义一个count，用于记录走的步数
     * 定义一个数组，用于记录每一位置的值
     * 顺时针扫描有4个方向，右:0、下:1、左:2、上:3，分别对应的i、j是：j++、i++、j--、i--
     *
     * 创建一个方法，功能是记录当前所处位置的值，并根据当前位置和方向判断下一步应该往哪走。
     *
     *
     * */
    public int[] spiralOrder(int[][] matrix) {
        //异常case
        if (matrix.length == 0) {
            return new int[0];
        }
        // 初始方向为0
        direction = 0;
        l1 = matrix.length;
        l2 = matrix[0].length;
        count = 0;
        array = new int[l1 * l2];
        visited = new boolean[l1][l2];
        walk(matrix, 0, 0);
        return array;
    }

    public void walk(int[][] matrix, int i, int j) {
        // 记录当前所在位置的值
        array[count] = matrix[i][j];
        count++;
        visited[i][j] = true;
        // 设置退出结点,count >= l1 * l2;
        if (count >= l1 * l2) {
            return;
        }
        // 根据当前的方向和位置判断下一步如何走
        if (direction == 0) {
            // 如果此时方向为向右，并且j<l2-1，那么j++，当j==l2的时候换为向下(i++)
            if (j < l2 - 1 && !visited[i][j + 1]) {
                j++;
            } else {
                direction = 1;
                i++;
            }
        } else if (direction == 1) {
            // 如果此时方向向下。i<l1-1&&下一个值没有被访问过，那么i++。否则换方向为向左（j--）
            if (i < l1 - 1 && !visited[i + 1][j]) {
                i++;
            } else {
                direction = 2;
                j--;
            }
        } else if (direction == 2) {
            if (j > 0 && !visited[i][j - 1]) {
                j--;
            } else {
                direction = 3;
                i--;
            }
        } else if (direction == 3) {
            if (i > 0 && !visited[i - 1][j]) {
                i--;
            } else {
                direction = 0;
                j++;
            }
        } else {
            return;
        }
        walk(matrix, i, j);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        Offer29 offer29 = new Offer29();
        System.out.println(Arrays.toString(offer29.spiralOrder(matrix)));
    }
}
