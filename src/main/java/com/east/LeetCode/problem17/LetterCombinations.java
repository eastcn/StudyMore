package com.east.LeetCode.problem17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname LetterCombinations
 * @Description  论自己都不知道怎么解出来的题是怎么通过的
 * @Date 2020/8/26 5:26 下午
 * @Created by East
 */
public class LetterCombinations {
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        find("", digits, map, 0);
        return list;
    }

    public void find(String s1, String s2, HashMap<String, String> map, int x) {
        int index = x;
        if (s1.length() == s2.length()) {
            if (!list.contains(s1)) {
                list.add(s1);
            }
            index = 0;
        }
        String s = String.valueOf(s2.charAt(index));
        if (s1.length() < s2.length()) {
            StringBuilder s1Builder = new StringBuilder(s1);
            for (int i = 0; i < map.get(s).length(); i++) {
                s1Builder.append(map.get(s).charAt(i));
                find(s1Builder.toString(), s2, map, index + 1);
                s1Builder.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations("2"));
    }
}
