package com.east.LeetCode.offerDemo11;

/**
 * @Classname minArray
 * @Description 就这。。居然是双100
 * @Date 2020/7/22 11:11 下午
 * @Created by East
 */
public class minArray {
    public static int minArray(int[] numbers) {
        int l = numbers.length;
        int end = 0;
        for (int i = 1; i < l; i++) {
            if (numbers[i - 1] > numbers[i]) {
                end = i;
            }
        }
        return numbers[end];
    }

    public static void main(String[] args) {
        int[] number = {3,4,5,1,2};
        System.out.println(minArray(number));
    }
}

