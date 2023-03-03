package com.east.LeetCode.InterviewProblems;

/**
 * Function: https://leetcode.cn/problems/bianry-number-to-string-lcci/
 *
 * @author taihua
 * @date 2023/3/2
 */
public class Interview05_02 {
    public static String printBin(double num) {
// 小数转二进制，将小数部分*2后取整数部分，之后重前一步，直到小数部分为0
// 因此由上可知，如果被转换的小数最后一位不是5，那么无论循环多少次都无法使得小数部分为0
// 思路：
// 1. 先判断num的最后一位是不是5，不是则返回error
// 2. 循环执行小数部分的*2取整行为
        double tempNum = num;
        while (tempNum % 1 != 0) {
            tempNum = tempNum * 10;
        }
        if ((int) tempNum % 5 != 0)
            return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0.0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            double temp = num * 2;
            int i = 1 - temp <= 0 ? (int) temp : 0;
            num = temp - i;
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printBin(0.2));
    }
}
