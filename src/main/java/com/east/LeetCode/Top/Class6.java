package com.east.LeetCode.Top;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Function: 环形链表
 *
 * @author taihua
 * @date 2024/2/21
 */
public class Class6 {
    /**
     * 思路1：暴力解法
     * 设置一个map来记录被访问过节点
     * 思路2：
     * 访问过的节点val都设置成0，以此来判断是否被访问过，需要修改节点本身的数据
     * 思路3：
     * 快慢双指针，原理就是快指针每次向前移动2慢指针向前移动1
     * 如果链表是环的话，快指针和慢指针一定会在某个位置相遇
     * 如果链表不是环，快指针访问到链表的最后时就可以跳出
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while (head.next != null) {
            ListNode temp = head;
            map.put(temp, true);
            if (map.containsKey(head.next)) {
                return true;
            } else {
                head = head.next;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        while (head != null && head.next != null) {
            if (head.next.val == 10000001) {
                return true;
            } else {
                head.val = 10000001;
                head = head.next;
            }
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                // 快指针到达链表尾部无法继续向下
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果跳出循环了说明快指针跟慢指针在某处相遇了
        return true;
    }
}
