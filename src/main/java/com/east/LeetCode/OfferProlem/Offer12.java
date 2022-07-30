package com.east.LeetCode.OfferProlem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function: 深度优先算法
 *
 * @author taihua
 * @date 2022/7/31
 */
public class Offer12 {
    /*
     *
     * 思路：DFS算法
     * 根据题中的，相邻单元格、同一格子中的元素不能重复使用可以判断出
     * 是要利用深度优先算法找出符合条件的顶点
     * DFS算法的关键在于
     *  1. 一个判断条件作为开始搜索的起点
     *  2. 如果是矩阵图，那么根据题目去递归不同的相邻点位，然后判断 数组越界+是否符合题目条件
     *  3. 访问过的点位修改为 其他字符，如空格； 但是再一次搜索失败的分支，回溯后需要恢复这个字符
     *
     *
     * */
    public boolean exist(char[][] board, String word) {
        if (board.length <= 0 || board[0].length <= 0) {
            return false;
        }
        if (word.length() <= 0) {
            return false;
        }
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 找到第一个字母的位置
                if (board[i][j] == wordArray[0]) {
                    // 设置一个记录本次搜索的位置列表
//                    List<String> positionRecord = new ArrayList<>();
                    // 换成Map，来提高查找速度
//                    Map<String, Boolean> positionRecord = new HashMap<>();
                    // 开始搜索
//                    if (DFS(board, wordArray, 0, i, j, positionRecord)) {
                    // 不用额外的数据结构去存储，通过修改矩阵中的字符实现记录是否重复访问的信息
                    if (DFS(board, wordArray, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, char[] wordArray, int wordIndex, int i, int j) {
        // 如果 查找的位置不在矩阵中了，则返回false
        // 如果 下一个字符不是word中的下一个则也返回
        // 如果 已经访问过了也返回false
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[i].length - 1 ||
                board[i][j] != wordArray[wordIndex]) {
            return false;
        } else {
            // 记录本次访问的地址
            board[i][j] = ' ';
//            String p = String.valueOf(i) + j;
//            positionRecord.put(p, true);
            // 如果已经到达这个字符的末尾，则返回true
            if (wordIndex == wordArray.length - 1) {
                return true;
            }
            // 字符位置后移一个
            int nextIndex = wordIndex + 1;
            // 查询当前点位可能存在的四个相邻点位
            if (DFS(board, wordArray, nextIndex, i - 1, j) ||
                    DFS(board, wordArray, nextIndex, i + 1, j) ||
                    DFS(board, wordArray, nextIndex, i, j + 1) ||
                    DFS(board, wordArray, nextIndex, i, j - 1)) {
                return true;
            } else {
                board[i][j] = wordArray[wordIndex];
                return false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] c = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
//                {'C', 'A', 'A'},
//                {'A', 'A', 'A'},
//                {'B', 'C', 'D'}
        };
        String word = "ABCESEEEFS";
        Offer12 o = new Offer12();
        System.out.println(o.exist(c, word));
    }
}
