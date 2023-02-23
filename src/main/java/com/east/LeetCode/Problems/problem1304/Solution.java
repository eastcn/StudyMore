package com.east.LeetCode.Problems.problem1304;

import java.util.Arrays;

/**
 * Function: 删除文件夹
 *
 * @author taihua
 * @date 2023/2/8
 */
public class Solution {
    public static int[] sumZero(int n) {
        int[] a = new int[n];
        int b = n / 2;
        boolean c = n % 2 > 0;
        if (c) {
            a[b] = 0;
            for (int i = 0; i < b; i++) {
                a[i] = -n / 2 + i;
            }
            for (int i = b + 1; i < n; i++) {
                a[i] = i - b;
            }
        } else {
            for (int i = 0; i < b; i++) {
                a[i] = -n / 2 + i;
            }
            for (int i = b; i < n; i++) {
                a[i] = i - b + 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(6)));
    }
}
