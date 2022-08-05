package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

/**
 * Function: 删除单结点
 *
 * @author taihua
 * @date 2022/8/4
 */
public class Offer18 {
    // 双指针循环，一个指向父结点，一个指向下个节点。 等遇到当前节点和val相同的，连接这两个指针的节点
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
        } else {
            ListNode parent = null;
            ListNode nodeNow = head;
            ListNode nodeNext = head.next;
            while (nodeNow.val != val) {
                parent = nodeNow;
                nodeNow = nodeNow.next;
                nodeNext = nodeNow.next;
            }
            parent.next = nodeNext;
        }
        return head;
    }
}
