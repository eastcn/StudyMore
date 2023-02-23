package com.east.LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 回文数字[easy]
 *
 * @author taihua
 * @date 2023/2/23
 */
public class problem9 {
    static class Solution {
        // 思路1：回文->双指针
        // 先遍历一遍这个数字用list记录下每一位的值，然后再双指针遍历这个list
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            List<Integer> list = new ArrayList<>();
            while (x >= 10) {
                list.add(x % 10);
                x = x / 10;
            }
            list.add(x);
            int i = 0;
            int j = list.size() - 1;
            while (i != j && i < list.size()) {
                if (list.get(i) != list.get(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        // 思路2: 既然是回文那么把这个数字反向一次应该是跟原来相等的
        public boolean isPalindrome2(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            int re = 0;
            int y = x;
            while (y >= 10) {
                re = re * 10 + y % 10;
                y = y / 10;
            }
            re = re * 10 + y;
            return re == x;
        }
    }
}
