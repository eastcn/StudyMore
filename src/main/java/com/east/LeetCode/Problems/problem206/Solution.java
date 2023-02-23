package com.east.LeetCode.Problems.problem206;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

/**
 * @Classname Solution
 * @Description TODO
 */
public class Solution {
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
