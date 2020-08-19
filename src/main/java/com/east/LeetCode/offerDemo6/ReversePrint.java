package com.east.LeetCode.offerDemo6;

/**
 * @Classname ReversePrint
 * @Description TODO
 * @Date 2020/8/19 9:26 下午
 * @Created by East
 */
public class ReversePrint {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (head.next != null) {
            size += 1;
            node = node.next;
        }
        int[] nums = new int[size];
        node = head;
        for (int i = size - 1; 0 <= i; --i) {
            nums[i] = node.val;
            node = node.next;

        }
        return nums;
    }
}
