package com.east.LeetCode.OfferProlem;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Function: 包含min函数的栈
 *
 * @author taihua
 * @date 2022/8/7
 */
public class Offer30 {
    /*
     * 思路
     * 理解题意，pop、push、top方法都是跟栈一样的，只是多了一个min函数。
     * 最重要的是min函数的时间复杂度要是O(1)，不能用遍历等，那么很明显是要把min值或者指针存下来。
     * 那么就是在在push的时候，每次都跟最小值比较，如果比最小值小，那么替换，若果大则放在栈顶
     * 然后考虑到，栈中数据是会变化的，那么当最小值被取出后，将最小值栈中的也弹出
     * 那么就需要用到数组来存储最小值的变化
     * */
    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minList = new Stack<>();

        public MinStack() {
        }

        public void push(int x) {
            stack.add(x);
            if (minList.isEmpty() || x <= minList.peek()) {
                minList.add(x);
            }
        }

        public void pop() {
            int x = stack.pop();
            if (!minList.isEmpty() && x == minList.peek()) {
                minList.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty())
                return stack.peek();
            else
                return 0;
        }

        public int min() {
            if (!minList.isEmpty())
                return minList.peek();
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.min());
    }
}
