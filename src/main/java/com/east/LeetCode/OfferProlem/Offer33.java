package com.east.LeetCode.OfferProlem;

/**
 * Function: 二叉搜索树的后序遍历序列
 *
 * @author taihua
 * @date 2022/8/9
 */
public class Offer33 {
    /**
     * 二叉搜索树特征：
     * 1. 左结点若不为空，则左子树上所有的结点值都小于根结点的值
     * 2. 右结点若不为空，则右子树上所有的结点值都大于根结点的值
     * 3. 二叉搜索树的子树也是二叉搜索树
     * <p>
     * 思路
     * 实现一个递归方法判断
     * 每一对二叉树结点是否都满足二叉搜索树的条件
     * 根据后序遍历可知，[左子树|右子树|根结点]，起始的根结点是明确的
     * 结合二叉搜索树的特征可以得到，
     * 越过左子树区域，进入右子树区域的时候一定会有一个值大于根结点的值
     * <p>
     * 这个值就可以用来作为分界点m
     * 以s、e表示一对二叉树的起始和结束的话,可以得到
     * [s,m-1] 是左子树区域
     * [m,e-1] 是右子树区域
     * 得到该分区结果后，再去验证是否符合二叉搜索树的特征。
     * <p>
     * 当我们在找m的时候，其实就已经验证了左子树是符合二叉搜索树的特征1。
     * 所以只需要遍历右子树区域判断其是否都大于根结点即 符合特征2
     * 再通过递归验证，左子树和右子树是否符合1、2
     */
    public boolean verifyPostorder(int[] postorder) {
        return valid(postorder, 0, postorder.length - 1);
    }

    public boolean valid(int[] postorder, int start, int end) {
        if (start > end) {
            return true;
        }
        int root = postorder[end];
        int m, point = start;
        while (postorder[point] < root) {
            point++;
        }
        // 跳出循环即找到了m
        m = point;
        // 找到m后，遍历右子树区域
        // 如果走到了最后那么就是符合二叉搜索树，没走到最后则不符合
        while (postorder[point] > root) {
            point++;
        }
        // 判断左右子树
        return point == end && valid(postorder, start, m - 1) && valid(postorder, m, end - 1);

    }

    public static void main(String[] args) {
        int[] i = new int[]{4, 8, 6, 12, 16, 14, 10};
        Offer33 o = new Offer33();
        o.verifyPostorder(i);
    }
}
