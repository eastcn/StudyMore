package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.east.LeetCode.BasicData.TreeNode.arrayToBTree;

/**
 * Function: 对称二叉树
 *
 * @author taihua
 * @date 2022/8/6
 */
public class Offer28 {
    /*
     * 思路，对称二叉树的特征是，在一对结点中，L=R,L.left = R.right,L.right=R.left
     * 实现一个函数，用于判断每对结点的值是否相等即可
     * */
    public boolean isSymmetric(TreeNode root) {
        // 特殊Case
        if (root == null)
            return true;
        else {
            return isMirror(root.left, root.right);
        }
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // 如果都为空，那么都是符合的
        if (left == null && right == null)
            return true;
            // 如果其中一个结点为空
        else if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 判断左结点的左结点和右结点的右结点是否相同 && 右结点的左结点和左结点的右结点是否相同
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    public static void main(String[] args) {
        TreeNode node = arrayToBTree(new int[]{1, 2, 2, 3, 4, 4, 3});
        Offer28 offer28 = new Offer28();
        offer28.isSymmetric(node);
    }
}
