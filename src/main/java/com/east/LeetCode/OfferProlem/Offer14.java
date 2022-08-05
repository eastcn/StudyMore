package com.east.LeetCode.OfferProlem;

/**
 * Function：
 * 数学推导
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
 *
 * @author taihua
 * @date 2022/7/31
 */
public class Offer14 {
    public int cuttingRope(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int x = n / 3;
        int m = n % 3;
        if (m == 1) {
            return (int) (Math.pow(3, x - 1) * 2 * 2);
        } else if (m == 2) {
            return (int) (Math.pow(3, x) * 2);
        } else {
            return (int) Math.pow(3, x);
        }
    }

    public static void main(String[] args) {
        Offer14 o = new Offer14();
        System.out.println(o.cuttingRope(10));
    }
}
