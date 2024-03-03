package com.east.LeetCode.Top;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

import java.util.HashMap;

/**
 * Function: 环形链表2
 *
 * @author taihua
 * @date 2024/3/2
 */
public class Class19 {
    /*
     * 思路1：暴力法
     * 用hashmap存储遍历过的节点，遍历的时候当遇到重复的节点说明成环
     * */
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            } else {
                map.put(head, true);
            }
            head = head.next;
        }
        return null;
    }

    /*
     * 思路2：快慢双指针
     * slow,fast指针向前移动的速度不一样，如果是环形那么一定会相遇，关键是如何找到那个入环的第一个节点
     * https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     * */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null) {
            slow = slow.next;
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                fast = head;
                break;
            }
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
