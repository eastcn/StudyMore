package com.east.LeetCode.ToOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/6/14
 */
public class Day1 {
    // 利用两个栈实现一个队列； 栈：先进后出，队列：先进先出；
    class CQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            s1.add(value);
        }

        public int deleteHead() {
            if (s2.empty()) {
                if (s1.empty()) {
                    return -1;
                } else {
                    while (!s1.empty()) {
                        s2.add(s1.pop());
                    }
                    return s2.pop();
                }
            } else {
                return s2.pop();
            }
        }
    }

    // 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
    // 思路，用一个list来记录stack的最小值操作，push和pop的时候都需要记录当前最小值的情况
    class MinStack {
        private LinkedList<Integer> stack;
        private LinkedList<Integer> minList;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minList = new LinkedList<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                minList.push(x);
            } else {
                if (minList.getFirst() >= x) {
                    minList.push(x);
                }
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop().equals(minList.getFirst())) {
                minList.pop();
            }
        }

        public int top() {
            return stack.getFirst();
        }

        public int min() {
            return minList.getFirst();
        }
    }
}

