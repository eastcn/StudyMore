package com.east.LeetCode.Top;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

/**
 * Function: 合并有序链表
 *
 * @author taihua
 * @date 2024/3/1
 */
public class Class18 {
    /*
     * 思路1：
     * 双指针遍历
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1, j = list2;
        // 关键1，要new一个新的链表头
        ListNode head = new ListNode(-1);
        // 关键2，创建一个指针指向这个链表头
        ListNode p = head;
        while (i != null && j != null) {
            // 关键3，在遍历的时候把指针的下一个指向更大的
            if (i.val < j.val) {
                p.next = i;
                i = i.next;
            } else {
                p.next = j;
                j = j.next;
            }
            p = p.next;
        }
        // 关键4， 如果i或者j有一个为空了，将另一个拼接上
        p.next = i == null ? j : i;
        // 最后，要返回新建的头的下一个，丢弃-1的节点
        return head.next;
    }
}
