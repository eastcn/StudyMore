package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/5
 */
public class Offer25 {
    // [1,2,4] [1,3,4]
    // 思路，另起一个新的节点
    // 然后双指针遍历两个节点，p1指向l1的头，p2指向l2的头
    // 先遍历l1, 当p1指向的节点<=p2指向的节点时，一直遍历，如果遇到p1>p2时弹出，并将此时新链表的next指向p2
    // 开始遍历l2，当p2<=p1时一直遍历，否则弹出，将新链表指回p1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode start = new ListNode(0), newHead;
        if (l1.val < l2.val) {
            newHead = l1;
            l1 = l1.next;
        } else {
            newHead = l2;
            l2 = l2.next;
        }
        start.next = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        if (l1 == null) {
            newHead.next = l2;
        }
        if (l2 == null) {
            newHead.next = l1;
        }
        return start.next;
    }
}
