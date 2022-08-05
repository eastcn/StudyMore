package com.east.LeetCode.OfferProlem;

import java.util.Stack;

/**
 * Function: 应该也是个搜索算法实现
 *
 * @author taihua
 * @date 2022/7/31
 */
public class Offer13 {
    /*
     *
     * 尝试一下广度优先算法，BFS
     * 需要有个队列记录接邻点 一个数组记录是否被访问过
     *
     * */
    public int movingCountBFS(int m, int n, int k) {
        // 用来记录未被访问还需被访问的领接点
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[m][n];
        // 把第一个点先放进栈
        stack.push(new int[]{0, 0});
        // 用于记录符合条件的结点
        int count = 0;
        while (!stack.empty()) {
            // 把栈顶的第一个取出来判断是否符合条件, 并记录是否被访问
            int[] p = stack.pop();
            int p0 = p[0];
            int p1 = p[1];
            int p0Count = numberCount(p0);
            int p1Count = numberCount(p1);

            if (p0Count + p1Count <= k && !visited[p0][p1]) {
                count = count + 1;
            }
            visited[p0][p1] = true;

            // 搜索相邻点, 在 m x n 的矩阵内，并且m+n <=k的邻点入栈
            if (p0 - 1 > 0 && numberCount(p0 - 1) + p1Count <= k && !visited[p0 - 1][p1]) {
                stack.push(new int[]{p0 - 1, p1});
            }
            if (p0 + 1 < m && numberCount(p0 + 1) + p1Count <= k && !visited[p0 + 1][p1]) {
                stack.push(new int[]{p0 + 1, p1});
            }
            if (p1 - 1 > 0 && p0Count + numberCount(p1 - 1) <= k && !visited[p0][p1 - 1]) {
                stack.push(new int[]{p0, p1 - 1});
            }
            if (p1 + 1 < n && p0Count + numberCount(p1 + 1) <= k && !visited[p0][p1 + 1]) {
                stack.push(new int[]{p0, p1 + 1});
            }
        }
        return count;
    }

    public int numberCount(int x) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }

    /*
     * 试一下DFS
     * */
    public int movingCount(int m, int n, int k) {
        // 记录是否被访问
        boolean[][] visited = new boolean[m][n];
        int[] index = new int[]{0, 0};
        return DFS(m, n, k, index, visited);
    }

    private int DFS(int m, int n, int k, int[] index, boolean[][] visited) {
        int p0 = index[0];
        int p1 = index[1];
        if (index[0] < 0 || index[1] < 0 || index[0] >= m || index[1] >= n
                || visited[index[0]][index[1]] || numberCount(p0) + numberCount(p1) > k) {
            return 0;
        } else {
            int count = 1;
            visited[p0][p1] = true;
            count += DFS(m, n, k, new int[]{p0 - 1, p1}, visited);
            count += DFS(m, n, k, new int[]{p0 + 1, p1}, visited);
            count += DFS(m, n, k, new int[]{p0, p1 - 1}, visited);
            count += DFS(m, n, k, new int[]{p0, p1 + 1}, visited);
            return count;
        }
    }

    public static void main(String[] args) {
        int m = 38, n = 15, k = 9;
        Offer13 o = new Offer13();
//        System.out.println(o.numberCount(38));
        System.out.println(o.movingCount(m, n, k));
    }

}
