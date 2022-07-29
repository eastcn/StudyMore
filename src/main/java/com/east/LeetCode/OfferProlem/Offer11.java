package com.east.LeetCode.OfferProlem;

/**
 * Function:
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author taihua
 * @date 2022/7/30
 */
public class Offer11 {
    /*二分法
     * 思路，首先要知道一个点：
     * 因为这个数组原先是升序的，
     * 所以不管这个数组旋转了多少次，从最小值往后走，它依然还是升序的。
     * 如[1,2,3,4,5] 旋转一次 => [2,3,4,5,1] 旋转2次 => [3,4,5,1,2] 旋转3次 => [5,1,2,3,4] 旋转4次 => [1,2,3,4,5]。。。。
     *
     * 所以通过二分法来缩小查询的范围
     * 举例： [4,5,6,7,1,2,3]
     * 那么是往左缩小（取left，mid）还是往右缩小(取mid，right)
     * 答案是往右，因为是升序且我们要找的是最小值。 如果往左，无论怎么缩减区域，一定会出现，前面升序突然遇到最小值的"无序"情况。
     * 那么就是开始二分
     * 分为三种情况
     * mid>right => 那么最小值肯定出现在右边区间，并且mid肯定不是最小值，所以下一次区间为[mid+1,right]
     * mid=right => 这种情况无法判断 最小值出现在哪，因为有可能最小值在mid的左边而mid-right全是重复的情况。所以排除right-1，[mid,right-1]
     * mid<right => 那么说明 mid - right是升序的最小值在左边或者mid就是最小值,所以下一个循环区间为[left,mid]
     * */
    public static int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0)
            return 0;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (right + left) >>> 1; // 移位运算 >>>1 即为 /2
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                right = right - 1;
            } else {
                right = mid;
            }
        }
        return numbers[right];
    }

    public static void main(String[] args) {
        int[] n = new int[]{3, 4, 5, 6, 1, 2, 2};
        System.out.println(minArray(n));
    }

}
