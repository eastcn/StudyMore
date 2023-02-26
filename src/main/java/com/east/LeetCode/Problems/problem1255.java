package com.east.LeetCode.Problems;

import java.util.*;

/**
 * Function:
 *
 * @author taihua
 * @date 2023/2/26
 */
public class problem1255 {
    // 思路： 暴力法
    // 先得到一个 letter的个数的map
    // 再得到一个可以组成的目标单词的list，并根据这个list得到其所有的子集
    // 遍历这个所有的子集并得到其最大值
    static class Solution {
        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            Map<Character, Integer> map = new HashMap<>();
            for (char letter : letters) {
                map.merge(letter, 1, Integer::sum);
            }
            List<String> list = new ArrayList<>();
            for (String word : words) {
                char[] chars = word.toCharArray();
                int j = 0;
                for (; j < chars.length; j++) {
                    if (map.get(chars[j]) == null) {
                        break;
                    }
                }
                if (j == chars.length) {
                    list.add(word);
                }
            }
            Map<String, Integer> scoreMap = new HashMap<>();
            for (String word : list) {
                scoreMap.put(word, getScore(word, score));
            }
            int maxScore = 0;
            List<List<String>> listList = findAllSubstrings(list, list.size());
            for (List<String> strings : listList) {
                Map<Character, Integer> tempMap = new HashMap<>(map);
                int tempScore = 0;
                for (String w : strings) {
                    char[] chars = w.toCharArray();
                    int y = 0;
                    for (; y < chars.length; y++) {
                        int num = tempMap.get(chars[y]);
                        if (num == 0) {
                            if (y != 0) {
                                for (int j = 0; j < y; j++) {
                                    tempMap.put(chars[j], tempMap.get(chars[j]) + 1);
                                }
                            }
                            break;
                        } else {
                            num = num - 1;
                            tempMap.put(chars[y], num);
                        }
                    }
                    if (y == chars.length) {
                        tempScore += scoreMap.get(w);
                    }

                }
                if (tempScore >= maxScore) {
                    maxScore = tempScore;
                }
            }
            return maxScore;
        }

        public int getScore(String word, int[] score) {
            int s = 0;
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                s += score[c - 'a'];
            }
            return s;
        }

        public List<List<String>> findAllSubstrings(List<String> stringList, int N) {
            // 使用位运算得到所有的子集合
            List<List<String>> list = new ArrayList<>();
            int allMasks = 1 << N;
            //如考虑空集 ，那么i的初始值为0
            for (int i = 1; i < allMasks; i++) {
                List<String> strList = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) > 0) {
                        strList.add(stringList.get(j));
                    }
                }
                list.add(strList);
            }
            list.add(stringList);
            return list;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] testWords = new String[]{"ac", "abd", "db", "ba", "dddd", "bca"};
        char[] testLetters = new char[]{'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'd', 'd', 'd', 'd'};
        int[] testScore = new int[]{6, 4, 4, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(s.maxScoreWords(testWords, testLetters, testScore));
    }
}
