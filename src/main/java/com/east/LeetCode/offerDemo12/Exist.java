package com.east.LeetCode.offerDemo12;

/**
 * @Classname Exist
 * @Description TODO
 * @Date 2020/8/19 10:16 下午
 * @Created by East
 */
public class Exist {
    static boolean[][] isWalked;

    static public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        boolean rs = false;
        int x = board.length;
        int y = board[0].length;
        isWalked = new boolean[x][y];
        char head = word.charAt(0);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == head && y > 1) {
                    for (int k = 1; k < word.length(); k++) {
                        char mid = word.charAt(k);
                        isWalked[i][j] = true;
                        if (isEqual(i, j, mid, board, isWalked) || isEqual(i + 1, j, mid, board, isWalked) || isEqual(i - 1, j, mid, board, isWalked)
                                || isEqual(i, j + 1, mid, board, isWalked) || isEqual(i, j - 1, mid, board, isWalked)) {
                            if (k == word.length() - 1) {
                                return true;
                            }
                        }
                    }
                } else if (board[i][j] == head && y == 1 && word.length() == 1) {
                    return true;
                }else if (board[i][j] == head && word.length() < y) {
                    return true;
                }
            }
        }
        return rs;
    }

    static public boolean isEqual(int i, int j, char word, char[][] board, boolean[][] isWalked) {
        boolean rs = false;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        } else {
            if (word == board[i][j] && !isWalked[i][j]) {
                isWalked[i][j] = true;
                rs = true;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
//        char[][] b = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] b = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] b = new char[][]{{'a'}};
//        String w = "ABCCED";
        String w = "a";
        char[][] b = new char[][]{{'a','a'}};
        System.out.println(exist(b, w));
    }
}
