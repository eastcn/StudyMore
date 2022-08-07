package com.east.LeetCode.BasicData;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 二叉树
 *
 * @author taihua
 * @date 2022/8/6
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public static TreeNode arrayToBTree(int[] arrs) {
        if (arrs.length == 1) {
            return new TreeNode(arrs[0]);
        }
        List<TreeNode> nodes = new ArrayList<>(arrs.length);
        for (int obj : arrs) {
            TreeNode treeNode = new TreeNode(obj);
            nodes.add(treeNode);
        }

        for (int i = 0; i < arrs.length / 2 - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i * 2 + 1);
            node.right = nodes.get(i * 2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arrs.length / 2 - 1;
        TreeNode lastPNode = nodes.get(lastPNodeIndex);
        lastPNode.left = nodes.get(lastPNodeIndex * 2 + 1);
        if (arrs.length % 2 != 0) {
            lastPNode.right = nodes.get(lastPNodeIndex * 2 + 2);
        }

        return nodes.get(0);
    }
}
