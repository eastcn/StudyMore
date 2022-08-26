package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.OfferProlem.offerProblem6.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 两个链表的第一个公共节点
 *
 * @author taihua
 * @date 2022/8/18
 */
public class Offer52 {
    /*
     * 思路
     * 先把这两个链表都遍历一遍，用数组记录（这个就不满足O(1)的要求了）
     * 然后先比较数组末尾是否相等，如果相等说明有相交点，然后开始各自回溯
     * 找到第一个不相等的点的下一个节点就是重合结点
     * */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        List<ListNode> a = new ArrayList<>();
        List<ListNode> b = new ArrayList<>();
        while (headA != null) {
            a.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            b.add(headB);
            headB = headB.next;
        }
        if (a.get(a.size() - 1) == b.get(b.size() - 1)) {
            int i = a.size() - 1, j = b.size() - 1;
            while (i >= 0 && j >= 0) {
                if (a.get(i) != b.get(j)) {
                    break;
                }
                i--;
                j--;
            }
            return a.get(i + 1); // 如果不等于,那么上一个是交点
        } else {
            return null;
        }
    }

    /*
     * 思路2
     * 双指针遍历
     * 如果链表a,b有重合，假设重合部分的长度为c
     * 那么 a-c 跟b-c 为各自链表不相等的长度
     *
     * 推导：（疑问：为什么能想到将两个链表首位连接？提示是什么）
     * 那么将a，b两条链表首尾连接，无论从a做头还是b做头，走到第二条链表的相交节点时的路径长度是一样的。
     * 如果以a链表做头，先遍历a，再遍历b直到走到相交节点，那么路径长度为： a+b-c
     * 如果以b链表做头，先遍历b，再遍历a直到走到相交节点，那么路径长度为： b+a-c
     * 如果a+b-c=b+a-c 那么就是相交
     *
     * 所以根据推导结论，在同一个循环中，如果相交肯定能得到 a==b
     * 如果没有交点，ab链表连接以后，其长度即 a+b，从a开始还是从b开始都会遍历到最后为null
     * 也即，null是他们的"交点"
     * */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;
    }
}
