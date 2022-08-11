package com.east.LeetCode.InterviewProblems;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/10
 */
public class Interview02_06 {
    /*
     * 回文链表
     * 思路
     * 把链表中的值都先读出来放在一个数组中
     * 然后首尾指针开始遍历，如果一直都是相等到中间位置，那么就是回文。
     * */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int s = 0, e = list.size() - 1, m;
        if (e % 2 == 1)
            m = e / 2;
        else m = e / 2 + 1;
        while (s < e && list.get(s).equals(list.get(e))) {
            s++;
            e--;
        }
        if (s < m) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * 栈，先压进去，然后取出来
     * 两个的数据应该是一样的
     * 但是要遍历两遍链表, 比双指针要慢
     * */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (temp != null && stack.pop() == temp.val) {
            temp = temp.next;
        }
        return stack.empty();
    }

    /*
     * 快慢指针方法
     * */
    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode end = reverseList(slow);
        while (end != null) {
            if (end.val != head.val) {
                return false;
            }
            end = end.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = null;
        ListNode nodeNow = head;
        while (nodeNow != null) {
            ListNode tempNode = nodeNow.next;
            nodeNow.next = pre;

            pre = nodeNow;
            nodeNow = tempNode;
        }
        return pre;
    }
}
