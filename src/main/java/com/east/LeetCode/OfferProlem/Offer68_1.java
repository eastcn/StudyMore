package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

/**
 * Function: 二叉搜索树的最近祖先
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author taihua
 * @date 2022/8/29
 */
public class Offer68_1 {
    /*
    * 思路
    * 结合二叉搜索数和题意
    * 当p、q在两侧子树时，此时的root为其公共祖先
    * 所以，当p、q同侧时遍历至，p、q在两侧子树或者p、q为其中一个root
    *
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // p、q都比root.val大，都在root的右子树
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // p、q都比root.val小，都在root的左子树
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
