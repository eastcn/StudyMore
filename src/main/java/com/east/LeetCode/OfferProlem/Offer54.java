package com.east.LeetCode.OfferProlem;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 二叉搜索树的第k大的点
 *
 * @author taihua
 * @date 2022/8/21
 */
public class Offer54 {
    /**
     * 二叉搜索树，思路1
     * 1.左子树结点一定比右子树结点小
     * 2.根结点一定比左边大，比右边小
     * 所以，中序遍历得到的就是按顺序排的，遍历到第k次即可
     */

    private final List<Integer> list = new ArrayList();

    public int kthLargest(TreeNode root, int k) {
        help(root);
        return list.get(list.size() - k);
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            list.add(root.val);
            help(root.right);
        }
    }

    /*
     * 思路2
     * 根据二叉搜索树的原理，右中序遍历可以得到倒排的数组
     * */
    public int kthLargest2(TreeNode root, int k) {
        help2(root, k);
        return list.get(k);
    }

    public void help2(TreeNode root, int k) {
        if (root != null && list.size() <= k) {
            help(root.right);
            list.add(root.val);
            help(root.left);
        }
    }

}
