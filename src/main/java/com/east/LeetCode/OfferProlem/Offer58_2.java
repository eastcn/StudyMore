package com.east.LeetCode.OfferProlem;

import java.util.Arrays;

/**
 * Function: 剑指 Offer 58 - II. 左旋转字符串
 *
 * @author taihua
 * @date 2022/9/15
 */
public class Offer58_2 {

    /*
     * 思路1：
     * 切片后，重新拼接
     * */
    public String reverseLeftWords(String s, int n) {
        if (s.length() <= 0) return s;
        if (n == 0) return s;
        if (n > s.length()) return s;
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2 + s1;
    }

    /*
     * 思路2：
     * 遍历替换
     * */
    public String reverseLeftWords2(String s, int n) {
        char[] newChs = new char[s.length()];
        char[] oldChs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                newChs[s.length() - n + i] = oldChs[i];
            } else {
                newChs[i - n] = oldChs[i];
            }
        }
        return String.valueOf(newChs);
    }

    public static void main(String[] args) {
        Offer58_2 o = new Offer58_2();
        System.out.println(o.reverseLeftWords2("lrloseumgh", 6));
    }
}
