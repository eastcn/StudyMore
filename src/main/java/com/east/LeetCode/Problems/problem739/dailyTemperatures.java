package com.east.LeetCode.Problems.problem739;

import java.util.Arrays;

public class dailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] R = new int[T.length];
        if (T.length > 30000) {
            return null;
        }
        for (int i = 0; i < T.length; i++) {
            if (i != T.length - 1) {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[i] < T[j]) {
                        R[i] = j - i;
                        break;
                    }
                }
            }else {
                R[i] = 0;
            }
        }
        return R;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73, 80, 75, 81};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }
}
