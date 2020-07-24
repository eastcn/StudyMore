package LeetCode;


import LeetCode.demo1.twoSum;
import LeetCode.demo17_13.Respace;

import java.util.Arrays;


public class main {
    public static void main(String[] args) {
//        Respace respace = new Respace();
//        String[] dict = {"looked", "just", "like", "her", "brother"};
//        String sentence = "jesslookedjustliketimherbrother";
//        System.out.println(respace.respace2(dict, sentence));
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        int target = -8;
        twoSum a = new twoSum();
        System.out.println(Arrays.toString(a.twoSum2(nums, target)));
    }
}
