package com.east.LeetCode.Problems;

import java.util.*;

/**
 * Function: https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 *
 * @author taihua
 * @date 2023/3/6
 */
public class problem1653 {
    public int minimumDeletions(String s) {
        // 官方题解
        // 一遍遍历，先记录下所有的a，然后再遍历一遍（从左到右），所以如果遇到a那都是左边的a，是不需要删除的，所以总的a--
        // 如果遇到b那么就是把左边的b++
        // 然后每次遍历都跟最小值删除值比较一下
        int leftB = 0, rightA = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'a') {
                rightA++;
            }
        }
        int min = rightA; // 先假设所有的a都要被删除
        for (char c : chars) {
            if (c == 'a') {
                rightA--; //如果遇到a，那么这些a都是左边的a，所以从总数a里面删除掉，剩下的就是右边的a
            } else {
                leftB++; // 如果遇到b，那么就是都是左边的b，所以要删除的b++
            }
            min = Math.min(min, leftB + rightA); // 拿要删除的a+b跟当前要删除的数量对比
        }
        return min;
    }

    public static int minimumDeletions2(String s) {
        // 思路
        // 问题为求 长度为n的字符串的平衡的最少删除次数
        // 可以尝试将该问题拆解为 长度为n-1的字符串中的最少删除次数
        // 那么如何才能将长度缩减呢？ 可以尝试根据题意从最简单的n=1 、 n=2(因为字符串长度不<1)或者f(n-1)和f(n-2)开始推演
        // 题意中明确说了, 一个平衡的字符串: a在左，b在右, 那么可以得到：
        // 字符串的最后一位如果是a，那么前面的b就需要都删除, 记为countB
        // 如果最后一位是b则需要看前一位的状态，所以问题就变成最后第二位是否为a, 如果是a那么就是子字符串(0,n-2)的最小删除值
        // 转化为方程:
        // if s[n] = a -> f(n) = countB
        // if s[n] = b -> f(n) = min(f(n-1), countB)
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars
        ) {
            if (c == 'b') {
                count++;
            }
        }
        return rec(chars, s.length() - 1, count);
    }

    public static int rec(char[] chars, int n, int countB) {
        if (chars.length == 1) return 0;
        if (chars[n] == 'a') {
            return countB;
        } else {
            countB--;
            return Math.min(rec(chars, n - 1, countB), countB);
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions2("bbaaaaabb"));
    }
}
