package com.east.JavaBasic.DataDemo;

import java.util.*;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/7/28
 */
public class Trees {
    // 树的遍历,递归
    public List<Integer> travel(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            // 如果传进来的结点是个null，直接返回空列表
            return result;
        }
        List<Integer> left = travel(root.left);
        List<Integer> right = travel(root.right);

        // 先序遍历
        result.add(root.value);
        result.addAll(travel(root.left)); // 先遍历左结点
        result.addAll(travel(root.right)); // 再遍历右结点

//        // 中序遍历
//        result.addAll(travel(root.left)); // 先遍历左结点
//        result.add(root.value);
//        result.addAll(travel(root.right)); // 再遍历右结点

        // 后序遍历
//        result.addAll(travel(root.left)); // 先遍历左结点
//        result.addAll(travel(root.right)); // 再遍历右结点
//        result.add(root.value);
        return result;
    }

    // 树的遍历，栈实现
    public List<Integer> travelByStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            // 如果传进来的结点是个null，直接返回空列表
            return result;
        }

        // new 一个空栈,并把根结点push进去
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.empty()) {
            // 取出栈顶的结点。 该结点即为本次循环中的根结点。
            TreeNode node = stack.pop();
            // 把value加入结果
            result.add(node.value);
            // 根据栈先入后出的特性，先把右结点压入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            // 再把左结点压入栈
            if (node.left != null) {
                stack.push(node.left);
            }
            // 下一次循环，栈顶的结点是本次循环的左结点
        }
        return result;
    }

    /**
     * 对于一颗二叉树其遍历结果抽象如下:
     * <p>
     * 先序遍历为[root, [pre left nodes], [pre right nodes]]
     * 中序遍历为[[in left nodes], root, [in right nodes]]
     * <p>
     * 因为对于一棵树的遍历，用先序遍历和中序遍历的结果长度都是一样的
     * 所以pre list nodes的长度=in left nodes的长度
     * <p>
     * 由上得到根据先序遍历中的第一个元素即root，然后找到其在中序遍历中所在的位置
     * 然后得到，left nodes的长度、right nodes的长度
     * 那么就能得到，pre left nodes、pre right nodes、in left nodes 和 in right nodes的结构
     * <p>
     * 继续推演 pre left nodes =>
     * 先序: [pre_root, [pre_pre left nodes], [pre_right nodes]]
     * 中序: [[in_left nodes],in_root, [in_right nodes]]
     * 那么就跟第一层的推演是一样的, 即可以得到递归的方法。
     * right侧也是一样,进行递归。
     */
    // 建立个中序的索引。 不建立也可以，但是这样每次递归都需要遍历数组,时间复杂度会高
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode rebuildTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight)
            return null;

        int root = preOrder[preLeft];
        int inIndex = indexMap.get(root);

        TreeNode treeNode = new TreeNode(root);

        // 根据中序遍历的结构，可以得到左树的结点数量。
        // 完整的为 中序root的index-中序数组的start + 1 - 1
        // + 1 是因为数组的长度 = start_index - end_index + 1
        // - 1 是因为此时的长度是以root为end计算的，但真正的左树的结点数不包含root
        int leftNodeLength = inIndex - inLeft;

        // 先序遍历的下一层树的数组的start=本层的start+1, end位置为start+结点数量
        treeNode.left = rebuildTree(preOrder, inOrder, preLeft + 1, preLeft + leftNodeLength, inLeft, inIndex - 1);

        // 右树也一样
        int rightNodeLength = inRight - inIndex;
        treeNode.right = rebuildTree(preOrder, inOrder, preLeft + 1 + leftNodeLength, preRight, inIndex + 1, inRight);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return rebuildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    static class TreeNode {

        public TreeNode parent;
        public TreeNode left;
        public TreeNode right;
        public int value;

        TreeNode() {

        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
