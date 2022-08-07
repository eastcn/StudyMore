package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

/**
 * Function: 反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author taihua
 * @date 2022/8/5
 */
public class Offer24 {
    /*
    * 思路是直接反转
    * 在遍历的时候把next取出来以后，先暂存
    * 再把next指向上一个节点
    * 然后准备进入下一层循环
    * 把下一层的上一个节点（pre）改为当前节点（此时的next已经指向上层了）
    * 然后把下一层的node从暂存处取出来，继续遍历
    * */
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
