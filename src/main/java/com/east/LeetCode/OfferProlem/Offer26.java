package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.Stack;

/**
 * Function: 数的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author taihua
 * @date 2022/8/6
 */
public class Offer26 {
    /*
     * 双指针，以先序遍历为基础。
     * 先开始遍历树A，当遇到A.val == B.val时，开始同时遍历B
     * 进入同时遍历过程：
     *   如果 A.val != B.val 那么结构不相等
     *   如果 A.val == B.val 一直遍历到B的最后一个叶子节点，那么结构相等。
     *
     *
     * */
    // 用栈做第一层的遍历
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (B == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        boolean result = false;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.val == B.val) {
                result = travelCompare(node, B);
                if (result) {
                    break;
                }
            }
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public boolean travelCompare(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return travelCompare(A.left, B.left) && travelCompare(A.right, B.right);
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null)
            return false;
        if (A != null) {
            return travelCompare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 3, 4};
        int[] arrays2 = new int[]{3};
        Offer26 o = new Offer26();
        o.isSubStructure(TreeNode.arrayToBTree(arrays), TreeNode.arrayToBTree(arrays2));
    }
}
