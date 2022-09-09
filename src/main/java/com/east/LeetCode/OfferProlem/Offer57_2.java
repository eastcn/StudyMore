package com.east.LeetCode.OfferProlem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Function: 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author taihua
 * @date 2022/9/9
 */
public class Offer57_2 {
    /*
     * 思路：
     * 滑动窗口-1，初始窗口是最大的窗口（非最优）
     * 入参，target
     * 初始化一个长度为windowLength = target/2 + 1的窗口
     * 判断其从1、2、... windowLength累加是否大于target，
     * 如果大于，那么windowLength-1，直到累加等于target或者窗口长度<2
     * 如果等于，那么记录该窗口中的数据，并将窗口的起始位置+1
     * 如果小于，那么窗口的起始位置+1
     * 如果窗口的起始位置超过target/2了，返回当前记录的数组
     * */
    public int[][] findContinuousSequence(int target) {
        List<int[]> resultList = new ArrayList<>();
        int windowStart = 1, windowEnd = target / 2 + 1;
        int sum = sum(windowStart, windowEnd);
        while (windowEnd - windowStart >= 1 && windowStart < (target / 2 + 1)) {
            if (sum > target && windowEnd - windowStart >= 1 && windowStart < (target / 2 + 1)) {
                // 窗口变小
                sum = sum - windowEnd;
                windowEnd--;
            }
            if (sum == target && windowEnd - windowStart >= 1 && windowStart < (target / 2 + 1)) {
                int[] array = buildArray(windowStart, windowEnd);
                resultList.add(array);
                // 窗口左移动，把sum处理一下，减掉老的start，加上新的end
                sum = sum - windowStart;
                windowStart++;
                windowEnd++;
                sum = sum + windowEnd;
            }
            if (sum < target && windowEnd - windowStart >= 1 && windowStart < (target / 2 + 1)) {
                // 窗口左移动，把sum处理一下，减掉老的start，加上新的end
                sum = sum - windowStart;
                windowStart++;
                windowEnd++;
                sum = sum + windowEnd;
            }
        }
        return resultList.toArray(new int[0][]);
    }

    private int sum(int start, int end) {
        int sum = 0;
        while (start <= end) {
            sum = sum + start;
            start++;
        }
        return sum;
    }

    private int[] buildArray(int windowStart, int windowEnd) {
        int size = windowEnd - windowStart + 1;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = windowStart + i;
        }
        return array;
    }

    /*
     * 思路2
     * 滑动窗口-2， 初始窗口为2，起点和结束点为1，2，窗口和为3
     * 当窗口的起点小于等于target/2时开始以下循环判断
     * 当窗口和小于target的时候，窗口扩大，
     * 当窗口和==target的时候，窗口右移动
     * 当窗口和大于target的时候，窗口减小,并右移
     * */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> resultList = new ArrayList<>();
        int windowStart = 1, windowEnd = 2, sum = 3;
        while (windowStart < windowEnd && windowStart <= target / 2) {

            if (sum == target) {
                int[] array = new int[windowEnd - windowStart + 1];
                for (int i = 0; i < windowEnd - windowStart + 1; i++) {
                    array[i] = windowStart + i;
                }
                resultList.add(array);
                sum -= windowStart;
                windowStart++;
                windowEnd++;
                sum += windowEnd;
            }
            if (sum < target) {
                windowEnd++;
                sum += windowEnd;
            }
            if (sum > target) {
                sum -= windowStart;
                windowStart++;
            }
        }
        return resultList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Offer57_2 o = new Offer57_2();
        System.out.println(Arrays.deepToString(o.findContinuousSequence2(89666)));
    }
}
