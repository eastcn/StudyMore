package com.east.LeetCode.problem2331;

import com.east.LeetCode.BasicData.TreeNode;

/**
 * Function:
 *
 * @author taihua
 * @date 2023/2/6
 */
public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        } else {
            if (root.val == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else {
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}
