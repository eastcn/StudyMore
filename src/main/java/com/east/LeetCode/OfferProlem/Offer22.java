package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author taihua
 * @date 2022/8/5
 */
public class Offer22 {
    // 思路1, 先遍历一遍链表，得到长度，然后拿到倒数第K个节点
    // 可以用List或者Map存链表的节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        nodes.add(node);
        while (node.next != null) {
            node = node.next;
            nodes.add(node);
        }
        return nodes.get(nodes.size() - k);
    }

    // 思路2，双指针遍历，保证两个指针之间的距离为k，当第一个指针走到最后节点时，第二个指针指向的即为倒数第K个
    public ListNode getKthFromEnd2(ListNode head, int k) {
        int p1 = 0, p2 = 0;
        ListNode node = head;
        ListNode node2 = head;
        while (node.next != null) {
            node = node.next;
            if (p1 - p2 >= k - 1) {
                p2++;
                node2 = node2.next;
            }
            p1++;
        }
        return node2;
    }
}
