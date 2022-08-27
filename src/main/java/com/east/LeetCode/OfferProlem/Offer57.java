package com.east.LeetCode.OfferProlem;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Function: 和为s的两个数字
 *
 * @author taihua
 * @date 2022/8/26
 */
public class Offer57 {
    // 思路1，遍历+二分
    // 从头开始遍历，第i个数，然后用s减去 nums[i],
    // 然后判断该值是否存在于nums中，因为递增所以 这个判断可以用二分法
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            int s = i, e = nums.length - 1;
            while (s < e) {
                int mid = (s + e) >>> 1;
                // 如果中间值比x小，说明x在m[mid+1,e]
                if (nums[mid] < x) {
                    s = mid + 1;
                }
                // 如果中间值比x大,说明x在[s,mid-1]
                if (nums[mid] > x) {
                    e = mid - 1;
                }
                if (nums[mid] == x) {
                    s = e = mid;
                    break;
                }
            }
            // 二分结束以后，判断x是否等于nums[s]，相等则存在，不相等则不存在
            if (nums[s] == x) {
                index1 = nums[i];
                index2 = nums[s];
                break;
            }
        }
        return new int[]{index1, index2};
    }

    // 思路2 双指针，时间复杂度甚至不如二分?
    // index1从0开始 index2从nums.length-1开始
    // 初始状态：index1 = 0,index2从nums.length-1开始-- 直到nums[index2] == target-nums[i] break；如果<，则index1+1
    //
    public int[] twoSum2(int[] nums, int target) {
        int index1 = 0, index2 = nums.length - 1;
        for (; index1 < nums.length; index1++) {
            int x = target - nums[index1];
            while (nums[index2] > x) {
                index2--;
            }
            if (nums[index2] == x) {
                break;
            }
        }
        return new int[]{nums[index1], nums[index2]};
    }

    // 思路3 HashMap O(n)
    // 遍历一次，用HashMap记录预期数字的可能
    // 然后在后续的遍历中判断当前值是否存在于预期值的hashMap中
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            // 判断预期值x是否存在map中, 并且判断数字对是否一致
            if (map.containsKey(nums[i]) && map.get(nums[i]).equals(x)) {
                return new int[]{nums[i], x};
            } else {
                map.put(x, nums[i]);
            }
        }
        return null;
    }

    // 思路4 双指针优化版
    // index1从0开始 index2从nums.length-1开始
    // 由于数组递增，并且一定存在两数合，那么target一定小于nums[0] + nums[nums.length-1]
    // 那么，可以据此来移动指针
    // 当 nums[index1] + nums[index2] > target时说明index2 太大，index2--
    // 当 nums[index1] + nums[index2] < target时说明index1 太小,index1++
    // 如果到最后index1>=index2了，这说明没有符合的数据
    public int[] twoSum4(int[] nums, int target) {
        int index1 = 0, index2 = nums.length - 1;
        while (index1 < index2) {
            if (nums[index1] + nums[index2] > target)
                index2--;
            if (nums[index1] + nums[index2] < target)
                index1++;
            if (nums[index1] + nums[index2] == target)
                return new int[]{nums[index1], nums[index2]};
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer57().twoSum3(new int[]{2, 7, 11, 15}, 9)));
    }

}
