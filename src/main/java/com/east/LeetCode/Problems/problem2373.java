package com.east.LeetCode.Problems;

/**
 * Function: https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 *
 * @author taihua
 * @date 2023/3/1
 */
public class problem2373 {
    public int[][] largestLocal(int[][] grid) {
        // 思路: 遍历 (n-2) x (n-2)的范围，并找到其中i+1,j+1的3x3矩阵中的最大值
        int[][] newGrid = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                newGrid[i][j] = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (k < grid.length && l < grid[0].length && grid[k][l] >= newGrid[i][j]) {
                            newGrid[i][j] = grid[k][l];
                        }
                    }
                }
            }
        }
        return newGrid;
    }

//    public int findMax(int i, int j, int[][] grid) {
//        int max = 0;
//        for (int k = i; k < i + 3; k++) {
//            for (int l = j; l < j + 3; l++) {
//                if (k < grid.length && l < grid[0].length && grid[k][l] >= max) {
//                    max = grid[k][l];
//                }
//            }
//        }
//        return max;
//    }
}
