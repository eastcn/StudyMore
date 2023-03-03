package com.east.LeetCode.Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: https://leetcode.cn/problems/making-file-names-unique/
 *
 * @author taihua
 * @date 2023/3/3
 */
public class problem1487 {
    public static String[] getFolderNames(String[] names) {
        // 思路：
        // 文件夹转成map处理，map记录所有输出过的文件夹名字和以该文件夹名字为前缀的同系列的数量
        // 如果数组中拿到的原始字符串已经存在
        //      那么拿到map中该字符串对应的后缀数量，+1后作为新文件夹名字
        //      对新文件夹名执行判重，如果新文件夹名在map中有，说明已经输出过了，那么计数再+1再判重，直到不重复。
        //      然后将这个原始字符串的计数修正为当前的计数，然后将得到的不重复的字符串放入map，计数为0
        // 如果不存在，直接放到map和输出的数组中。
        Map<String, Integer> map = new HashMap<>();
        String[] ret = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String currentStr = names[i];
            if (map.get(currentStr) != null) {
                int count = map.get(currentStr);
                count++;
                String nextStr = currentStr + "(" + count + ")";
                while (map.get(nextStr) != null) {
                    count++;
                    nextStr = currentStr + "(" + count + ")";
                }
                map.put(currentStr, count);
                map.put(nextStr, 0);
                ret[i] = nextStr;
            } else {
                map.put(currentStr, 0);
                ret[i] = currentStr;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)","kaido(1)(1)", "kaido(2)"})));
    }
}
