package com.east.LeetCode.demo1025;

/**
 * @Classname divisorGame
 * @Description TODO
 * @Date 2020/7/25 12:16 上午
 * @Created by East
 */
public class Solution {
    static public boolean divisorGame(int N) {
       /* 方法1： 数学思想，最佳状态下， Alice拿到偶数，则可以让对方一直拿奇数，循环到最后，Alice最后拿到2，必胜。
       反过来如果开局Alice拿到 奇数，对方可以让她一直拿奇数，因此必输。 */
//        return N % 2 == 0;
        /*方法2：以alice为视角，在N<=3时，alice分别为false，true，false。
        因此f(N)可以转换为f(3)以下的状态
        * */
        boolean[] result = new boolean[N + 2];
        result[1] = false;
        result[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 & !result[i - j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[N];
    }
}
