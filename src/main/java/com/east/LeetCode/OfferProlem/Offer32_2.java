package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Function: 从上到下打印二叉树 II
 * <p>
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @author taihua
 * @date 2022/8/8
 */
public class Offer32_2 {
    List<List<Integer>> nodes = new ArrayList<>();

    /**
     * 思路1
     * 同Offer32.java 中的思路1
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root != null)
            nodeList.add(root);
        addNodes(nodeList);
        return nodes;
    }

    private void addNodes(List<TreeNode> nodeList) {
        List<Integer> levelNodes = new ArrayList<>();
        if (!nodeList.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode node : nodeList) {
                levelNodes.add(node.val);
                if (node.left != null)
                    nextLevelNodes.add(node.left);
                if (node.right != null)
                    nextLevelNodes.add(node.right);
            }
            nodes.add(levelNodes);
            addNodes(nextLevelNodes);
        }
    }

    /**
     * 思路2
     * 同Offer32.java中的思路2
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> nodesList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.add(root);
        } else
            return nodesList;
        while (!nodeQueue.isEmpty()) {
            List<Integer> nodeList = new ArrayList<>();
            // 这里用int i = nodeQueue.size() 而不是 i < nodeQueue.size()
            // 因为在for循环中 变量i只初始化一次，
            // 而nodeQueue.size在每次判断的时候都会变化。
            // 现在这种写法，可以变成 => int size = nodeQueue.size(); for(int i=0;i<size;i++){}
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode n = nodeQueue.poll();
                nodeList.add(n.val);
                if (n.left != null)
                    nodeQueue.add(n.left);
                if (n.right != null)
                    nodeQueue.add(n.right);
            }
            nodesList.add(nodeList);
        }
        return nodesList;
    }
}
