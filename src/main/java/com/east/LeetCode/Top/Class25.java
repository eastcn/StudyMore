package com.east.LeetCode.Top;

import com.east.LeetCode.BasicData.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Class25 {
    /*
     * 思路：
     * 记录当前层数，处在同一层的往数组中加入
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> map = new ArrayList<>();
        addVal(root, 0, map);
        return map;
    }

    public void addVal(TreeNode node, int level, List<List<Integer>> map) {
        if (node == null) {
            return;
        }
        if (map.size() > (level)) {
            map.get(level).add(node.val);
        } else {
            List<Integer> tempRes = new ArrayList<>();
            tempRes.add(node.val);
            map.add(level, tempRes);
        }
        level++;
        addVal(node.left, level, map);
        addVal(node.right, level, map);
    }
}
