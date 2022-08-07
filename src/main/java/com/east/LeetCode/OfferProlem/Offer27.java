package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

/**
 * Function:
 * <p>
 * 完成二叉树镜像
 *
 * @author taihua
 * @date 2022/8/6
 */
public class Offer27 {
    /*
     *      * 思路：先序遍历，每个结点交换左右

     * */
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode head = new TreeNode(0);
        head.left = root;
        mirror(root);
        return head.left;
    }

    public void mirror(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            mirrorTree(node.left);
            mirrorTree(node.right);
        }
    }
}
