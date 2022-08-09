package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.east.LeetCode.BasicData.TreeNode.arrayToBTree;

/**
 * Function: 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author taihua
 * @date 2022/8/8
 */
public class Offer32_3 {
    /**
     * 思路1
     * 在Offer32的基础上，
     * 定一个count用来判断是第奇数层还是偶数层，递归方法中修改add的顺序
     * 奇数从左到右，先左结点再右结点
     * 偶数从右到左，先右结点再左结点
     */

    List<List<Integer>> nodes = new ArrayList<>();
    int level = 0;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root != null)
            nodeList.add(root);
        addNodes(nodeList);
        return nodes;
    }

    private void addNodes(List<TreeNode> nodeList) {
        List<Integer> levelNodes = new ArrayList<>();
        level++;
        if (!nodeList.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
//            for (TreeNode node : nodeList) {
//                levelNodes.add(node.val);
//            }
            // 读的时候根据是奇数还是偶数，来决定是正向读还是反向读
            // 塞的时候都是要正向塞
            if (level % 2 == 1) {
                for (TreeNode node : nodeList) {
                    levelNodes.add(node.val);
                }
            } else {
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    TreeNode node = nodeList.get(i);
                    levelNodes.add(node.val);
                }
            }
            for (TreeNode node : nodeList) {
                if (node.left != null)
                    nextLevelNodes.add(node.left);
                if (node.right != null)
                    nextLevelNodes.add(node.right);
            }
            nodes.add(levelNodes);
            addNodes(nextLevelNodes);
        }
    }

    public static void main(String[] args) {
        TreeNode node = arrayToBTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        Offer32_3 o = new Offer32_3();
        System.out.println(Arrays.toString(o.levelOrder(node).toArray()));
    }
}
