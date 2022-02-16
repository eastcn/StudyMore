package com.east.LeetCode.problem496;

public class nextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] R = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            R[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    if (j < nums2.length-1){
                        for (int k = j+1; k < nums2.length; k++) {
                            if (nums1[i] < nums2[k]){
                                R[i] = nums2[k];
                                break;
                            }
                        }
                    }
                }
            }
        }
        return R;
    }
}
