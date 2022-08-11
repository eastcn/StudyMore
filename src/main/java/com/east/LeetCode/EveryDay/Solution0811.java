package com.east.LeetCode.EveryDay;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 重新格式化字符串
 *
 * @author taihua
 * @date 2022/8/11
 */
public class Solution0811 {
    /*
     * 思路1
     * 特殊情况：如果字符长度<2，那其本身就是符合题意的
     * 先遍历一遍字符串，把其中的字符和数字分别存在两个数组中
     * 判断不支持情况，其中一个数组为空
     * 重组数组，长度更长的字符类型放在奇数位，短的放在偶数位
     * */
    public String reformat(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        for (char c : chars
        ) {
            // 是数字
            if (9 >= (c - '0') && (c - '0') >= 0) {
                intList.add(Integer.parseInt(String.valueOf(c)));
            } else {
                strList.add(String.valueOf(c));
            }
        }
        if (strList.isEmpty() || intList.isEmpty()) {
            return "";
        } else if (Math.abs(strList.size() - intList.size()) > 1) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (strList.size() >= intList.size()) {
                int i = 0;
                for (; i < intList.size(); i++) {
                    stringBuilder.append(strList.get(i)).append(intList.get(i));
                }
                if (i < strList.size()) {
                    stringBuilder.append(strList.get(strList.size() - 1));
                }
            } else {
                for (int i = 0; i < strList.size(); i++) {
                    stringBuilder.append(intList.get(i)).append(strList.get(i));
                }
                stringBuilder.append(intList.get(intList.size() - 1));
            }
            return stringBuilder.toString();
        }
    }
}
