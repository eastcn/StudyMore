package com.east.LeetCode.EveryDay;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 0729
 *
 * @author taihua
 * @date 2022/7/29
 */
public class Solution0729 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        /*
         * 几何题？
         * 一个 有效的正方形 有四条等边和四个等角(90度角)。
         * 穷举 + 边长 + 斜边
         */
        int square12 = square(p1, p2);
        int square13 = square(p1, p3);
        int square14 = square(p1, p4);
        // 边长都不能为0
        if (square12 == 0 || square13 == 0 || square14 == 0)
            return false;
        // 确定正方形的边长（这里side是正方形边长的平方）
        int side = 0;
        if (square12 == square13 && square13 * 2 == square14) {// 4是斜边
            side = square12;
            if (square(p2, p4) != side || square(p3, p4) != side || square(p3, p2) != 2 * side)
                return false;
            // 4条边都相等肯定是菱形，如果菱形的一个对角线的平方是边长平方的2倍，他肯定是正方形
        } else if (square12 == square14 && square12 * 2 == square13) {//3是斜边
            side = square12;
            if (square(p2, p3) != side || square(p3, p4) != side || square(p4, p2) != 2 * side)
                return false;
        } else if (square13 == square14 && square13 * 2 == square12) {//2是斜边
            side = square13;
            if (square(p2, p4) != side || square(p3, p2) != side || square(p3, p4) != 2 * side)
                return false;
        } else { // 否则不是正方形
            return false;
        }
        return true;

    }

    public int square(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
