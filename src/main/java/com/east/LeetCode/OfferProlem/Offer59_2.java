package com.east.LeetCode.OfferProlem;

import java.util.*;

/**
 * Function: 队列的最大值
 *
 * @author taihua
 * @date 2022/8/11
 */
public class Offer59_2 {
    /*
     * 思路，这一题跟实现栈的最小值（offer30）类似
     * 栈的特性是，先进后出，后进先出
     * 实现最小值的方法思路是：
     * 加入一个辅助栈，
     * 1. 辅助栈为空时，push一个值进来就是最小值，
     * 2. 再push进来的值时，判断如果比原先的值小则不push入辅助栈，比最小值小再push进辅助栈
     * 解释：
     * 因为栈的特性，后push进来的值如果不是最小值，即使它被pop出去了，此时栈的最小值依然还在栈中
     * 所以后push入的非最小值的数，对栈的最小值没有影响，不必计入辅助栈。
     *
     * 回到本题
     * 队列的特性，先进先出，然后要实现的是最大值
     * 根据栈的思路，实现一个辅助队列，用于维护最大值
     * 当辅助队列为空时，push进一个值就是最大值
     * 再次push值进来时，判断它是否比当前辅助队列中的最大值大，如果是的话就加入队列
     * 然后根据队列的特性，如果第一个值push进来的就是最大值，当主队列中的值被取出后，那将无法判断使用辅助队列判断剩下来的值哪个最大
     * 因为根本就没有入辅助队列
     * 所以，要对这个push进辅助队列的逻辑再加一步
     * 为了使辅助队列发挥其作用，应当维护起一个，队列中当前最大值的递减序列
     * 即：
     * 当有新值进来时，从辅助队列的尾部开始遍历，比新值小的全部pop掉
     * （因为他们是先进的数而新进值大于他们，所以他们即使被pop出去，也不会影响最大值）
     *
     * */
    class MaxQueue {
        private Queue<Integer> queue;
        private Deque<Integer> helpList;

        public MaxQueue() {
            queue = new LinkedList<>();
            helpList = new LinkedList<>();
        }

        public int max_value() {
            if (queue.isEmpty())
                return -1;
            else
                return helpList.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            if (helpList.isEmpty()) {
                helpList.push(value);
            } else {
                while (!helpList.isEmpty() && value > helpList.peekLast()) {
                    helpList.pollLast();
                }
                helpList.offer(value);
            }
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            if (queue.peek().equals(helpList.peek())) {
                helpList.pop();
            }
            return queue.poll();
        }
    }
}
