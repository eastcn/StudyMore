package com.east.LeetCode.Problems.problem1812;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/12/5
 */
class Solution {
    public static boolean squareIsWhite(String coordinates) {
        boolean[][] map = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = ((j + 1) % 2 != 0 || (i + 1) % 2 != 0) && ((j + 1) % 2 != 1 || (i + 1) % 2 != 1);
            }
        }
        char[] chars = coordinates.toCharArray();
        int x = chars[0] - 'a';
        int y = Integer.parseInt(String.valueOf(chars[1])) - 1;
        return map[x][y];
    }

    public static boolean squareIsWhite2(String coordinates) {
        char[] chars = coordinates.toCharArray();
        int x = chars[0] - 'a' + 1;
        int y = chars[1] - '0';
        return ((y + 1) % 2 != 0 || (x + 1) % 2 != 0) && ((y + 1) % 2 != 1 || (x + 1) % 2 != 1);

    }


    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(squareIsWhite2("a1"));
    }
}
