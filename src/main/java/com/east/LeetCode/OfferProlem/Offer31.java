package com.east.LeetCode.OfferProlem;

import java.util.Stack;

/**
 * Function: 栈的压入、弹出序列
 *
 * @author taihua
 * @date 2022/8/8
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 思路：
        // 用一个辅助栈来模拟，两个数组的操作;
        // 用一个指针来模拟弹出的操作
        // 初始指针为0，当有poped中有一个能弹出以后则把辅助栈中的弹出，并且i++来模拟第二个数弹出
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            // 把值压入
            s.push(num);
            // 按poped的顺序能否输出
            while (!s.isEmpty() && s.peek() == popped[i]) {
                // 如果能按数组的顺序输出了
                s.pop();
                i++;
            }
        }
        // 最后判断栈是否为空，如果为空了，返回true，否则返回false
        return s.isEmpty();
    }
}
