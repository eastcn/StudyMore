package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Function: 剑指 Offer 55 - I. 二叉树的深度
 *
 * @author taihua
 * @date 2022/8/25
 */
public class Offer55 {
    /*
    DFS
    深度优先，递归实现拿到当前左右子树的最大深度，返回+1；
    */
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else {
            return 0;
        }
    }

    /*
     * 思路2
     * 用数组来维护遍历，再用一个内部数组来记录每层的结点
     * 第一层，先把root压入栈
     * 遍历当前数组的结点，将其左右结点加入内部数组，然后层级+1，并将内部栈赋给外部数组。
     * */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        int count = 1;
        while (!treeNodes.isEmpty()) {
            List<TreeNode> stack = new ArrayList<>();
            for (TreeNode node : treeNodes) {
                if (node.left != null || node.right != null) {
                    if (node.left != null)
                        stack.add(node.left);
                    if (node.right != null)
                        stack.add(node.right);
                }
            }
            if (!stack.isEmpty()) {
                count++;
            }
            treeNodes = stack;
        }
        return count;
    }

}
