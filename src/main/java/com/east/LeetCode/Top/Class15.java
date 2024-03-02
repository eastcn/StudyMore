package com.east.LeetCode.Top;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

import java.util.HashMap;

/**
 * Function: 相交链表
 *
 * @author taihua
 * @date 2024/2/27
 */
public class Class15 {
    /*
     * 思路1：暴力解法
     * 先遍历一遍a链表，并用一个额外的结构（数组或者是map）来记录节点的访问情况
     * 再遍历一遍b链表，同时检查下一个节点是否被访问过，如果被访问过则相交返回下一个节点
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode head = headA;
        while (head != null) {
            map.put(head, true);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            } else {
                head = head.next;
            }
        }
        return null;
    }

    /*
     * 思路2：双指针遍历, 如果是相交的数组总是会相遇的
     * 设置两个指针A和B，A先遍历链表A再遍历链表B，B先遍历链表B再遍历链表A
     * 如果是相交链表，那么A和B指针在遍历的过程中一定会相遇，如果不相交，那么各自遍历到最后返回null
     * */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a!=b) {
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }
        return a;
    }
}
