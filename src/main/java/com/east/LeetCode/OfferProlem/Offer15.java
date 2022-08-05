package com.east.LeetCode.OfferProlem;

/**
 * Function:
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/submissions/
 *
 * @author taihua
 * @date 2022/8/1
 */
public class Offer15 {
    // 思路 主要有两点
    //
    // 1. 通过 (n&1)是否等于1来判断 二进制的最后一位是否为1
    // 2. 通过 >>> 1 来右移，高位补0，来遍历二进制
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Offer15 o = new Offer15();
        System.out.println(o.hammingWeight(128));
    }
}
