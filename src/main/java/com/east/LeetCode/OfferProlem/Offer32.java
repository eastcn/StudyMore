package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Function: 从上到下打印二叉树
 *
 * @author taihua
 * @date 2022/8/8
 */
public class Offer32 {
    List<Integer> nodes;

    /**
     * 思路1：
     * 实现一个递归函数
     * 入参：同一层的所有结点
     * 方法实现：把传入的结点的val都加入数组，并找出下一层的所有结点，作为下一次递归的入参
     * 退出条件：传入的结点List为空
     */
    public int[] levelOrder(TreeNode root) {
        nodes = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        if (root != null)
            nodeList.add(root);
        addNodes(nodeList);
        int[] r = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            r[i] = nodes.get(i);
        }
        return r;
    }

    private void addNodes(List<TreeNode> nodeList) {
        if (!nodeList.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode node : nodeList) {
                nodes.add(node.val);
                if (node.left != null)
                    nextLevelNodes.add(node.left);
                if (node.right != null)
                    nextLevelNodes.add(node.right);
            }
            addNodes(nextLevelNodes);
        }
    }

    /**
     * 思路2：
     * 使用一个队列来保存结点，把每一层的结点都加入到队列中，然后循环弹出
     * 因为队列 先进先出的特性。
     *  同一层的结点都会从左到右的add并按先进先出的顺序取出
     *  上层的顺序相同，下层的结点加入顺序也会相同。
     */
    public int[] levelOrder2(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.add(root);
        } else
            return new int[0];
        while (!nodeQueue.isEmpty()) {
            TreeNode n = nodeQueue.poll();
            nodeList.add(n.val);
            if(n.left != null)
                nodeQueue.add(n.left);
            if(n.right != null)
                nodeQueue.add(n.right);
        }
        int[] r = new int[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            r[i] = nodeList.get(i);
        }
        return r;
    }
}

