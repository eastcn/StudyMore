package com.east.LeetCode.OfferProlem;

/**
 * Function: 不用加减乘除实现加法。使用位运算。
 *
 * @author taihua
 * @date 2022/8/15
 */
public class Offer65 {
    /*
     * 思路
     * 将a，b转为二进制
     * 1. 当无进位时，亦或运算与加法相同
     * 2. 当需要进位时，先与运算得到进位，再左移一位。
     * */
    public int add(int a, int b) {
        while (b != 0) {
            // 如果有进位，则处理进位: 与运算，再左移, 用临时值保存进位后的值
            int c = (a & b) << 1;
            // 处理没有进位时的值相加
            a ^= b;
            b = c;
        }
        return a;
    }
}
