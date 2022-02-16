package com.east.LeetCode.offerProblem4;

/**
 * @Classname FindNumberIn2DArray
 * @Description TODO
 * @Date 2020/8/19 6:39 下午
 * @Created by East
 */
public class FindNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        boolean r = false;
        if (matrix.length == 0) {
            return false;
        } else {
            for (int i = 0; i < matrix.length; i++) {
                int l = matrix[i].length;
                if (l == 0){
                    break;
                }
                if (l == 1){
                    if (target == matrix[i][1]) {
                        r = true;
                        break;
                    }
                }
                if (target > matrix[i][0] && target < matrix[i][l - 1]) {
                    for (int j = 0; j < l; j++) {
                        if (target == matrix[i][j]) {
                            r = true;
                            break;
                        }
                    }
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{{}};
//        int[][] x = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}};
        System.out.println(findNumberIn2DArray(x, 4));
    }

}
