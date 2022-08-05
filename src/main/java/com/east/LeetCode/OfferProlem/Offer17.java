package com.east.LeetCode.OfferProlem;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/4
 */
public class Offer17 {

    // 如果这题是这样的话，那似乎没有什么意义。
    public int[] printNumbers(int n) {
        int x = (int) Math.pow(10,n);
        int[] r = new int[x - 1];
        for(int i=1; i<x;i++){
            r[i-1] = i;
        }
        return r;
    }
}
