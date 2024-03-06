package com.east.LeetCode.Top;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

public class Class23 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        // 双指针
        // 一个指针node指向当前的node，并记录一个当前值
        // 另一个指针nodeNext指向下一个节点，判断是不是跟当前值重复，
        // 如果重复nodeNext则指针后移动直到不重复,然后把node.next指向不重复的nodeNext，
        // 并且记录当前nodeNext的值，然后把node的指针后移到next
        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode node = head;
            int repeat = node.val;
            while (node != null) {
                ListNode nextNode = node.next;
                while (nextNode != null && nextNode.val == repeat) {
                    nextNode = nextNode.next;
                }
                node.next = nextNode;
                if (nextNode != null) {
                    repeat = nextNode.val;
                }
                node = node.next;
            }
            return head;
        }
        // 如果当前值和下一个值相等，则把下一个节点指向下下个
        // 不相等则指针直接后移
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode node = head;
            while(node.next != null){
                if (node.val == node.next.val){
                    node.next = node.next.next;
                }else{
                    node = node.next;
                }
            }
            return head;
        }

}
