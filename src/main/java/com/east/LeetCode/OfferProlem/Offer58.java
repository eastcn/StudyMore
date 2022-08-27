package com.east.LeetCode.OfferProlem;

/**
 * Function: reverseStringArray
 *
 * @author taihua
 * @date 2022/8/27
 */
public class Offer58 {
    // 思路1
    // 用split分割再反加
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        String r = "";
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].length() > 0) {
                r = r + array[i] + " ";
            }
        }
        return r.substring(0, r.length() - 1);
    }

    // 思路2 快慢双指针, 主要是判断字符的开始和结束
    // 不使用split()等内建方法
    // 开始，ij都在尾部
    // 1。i先走，找到第一个空格，即找到了一个word: [i+1,j+1]
    // 2。此时再让i往前找到第一个字符，即找到了下个word的末尾，将i赋予j
    // 然后循环1，2
    public String reverseWords2(String s) {
        s = s.trim();
        int i = s.length() - 1, j = s.length() - 1;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && chars[i] != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && chars[i] == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        new Offer58().reverseWords("  hello world!  ");
    }
}
