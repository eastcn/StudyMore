package com.east.LeetCode.Problems;

import java.util.HashMap;

/**
 * Function: 缺失的最小正整数
 *
 * @author taihua
 * @date 2024/2/23
 */
public class problem41 {
    public int firstMissingPositive(int[] nums) {
        /*
        动态规划
        状态转移方程 f(n) = nums[n] != f(n-1) => f(n-1); nums[n]=f(n-1)=>f(n-1)+1;
        边界情况，f(1) = nums[0] =1 => f(1) = 2,nums[0]!=1 f(1)=1;
         */
        int minPositive;
        if (nums[0] == 1) {
            minPositive = 2;
        } else {
            minPositive = 1;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
            if (nums[i] == minPositive) {
                minPositive++;
                while (map.containsKey(minPositive)) {
                    minPositive++;
                }
            }
        }
        return minPositive;
    }


    /**
     * 思路：
     * 一个n长度的字符串，其缺失的最小正数一定也是在[1,n+1]
     * 极限情况是n+1即1-n的数字在nums都存在
     * 那么假设这个数组就是一个极限情况，最理想的情况下就是nums[n-1] =n
     * 那么就可以尝试把一个1-n的正数，放到其应该在的位置上，非1-n的数则改成负数作为不需要关心的数
     * 那么能找到的第一个索引跟value不匹配的就是最小的正数
     */
    public int firstMissingPositive1(int[] nums) {
        int res = nums.length+1;
        for (int i = 0; i < nums.length; i++) {
            // 把它放到跟索引匹配的位置上
            // 判断一下当前索引位置上的值是否在[1,n]如果是的话这个也是需要判断的那还需要继续换,但是如果两个值一样的话就不再交换
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        problem41 p = new problem41();
        System.out.println(p.firstMissingPositive1(new int[]{1}));
    }
}
