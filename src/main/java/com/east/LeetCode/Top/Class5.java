package com.east.LeetCode.Top;

/**
 * Function: 最长回文串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author taihua
 * @date 2024/2/20
 */
public class Class5 {
    /*
     * 思路1：
     *
     * 该题需要解决两个问题：
     * 1. 如何确定一个字符串是回文串？
     * 方法1：双指针
     *   首尾指向的字符是同一个则首+1尾-1，直到首尾指针相等或者左比右大（偶数长度下左++，右--出现）。
     * 方法2：栈
     *   单指针遍历，借助栈的特性，指针未越过字符中间值时向栈内push，越过字符中间值后，判断指针指向的与栈顶的字符是否一致。
     *   需要注意字符长度的奇偶，如果是奇数则字符中间值可以忽略。
     * 方法3：动态规划
     *   要判断一个子串s[i,j]是不是回文，可以分为三种情况，
     *      1. 子串长度=1的时候一定是回文
     *      2. 子串长度=2的时候, s[i]=s[j]则为回文否则不是
     *      3. 子串长度>2的时候, s[i,j]是否为回文=s[i+1,j-1]&&s[i]==s[j]
     *   根据动态规划的思想，3即为状态转移方程，1，2为边界情况
     * 2. 如何找到最长的子串？
     * 方法1：暴力解法
     *   双指针遍历找到所有的子串，判断是不是回文并对比
     *
     * 思路2:
     * 从回文的特点出发，回文的特点是中心对称
     * 根据这个对称的特性可以想到，当找到一个回文时，它的左右边界扩大后也有可能是回文。
     * 而每一个单独的字符就是回文，所以逻辑上，随便选一个字符，然后先后扩大其左右边界，如果是回文，那就继续扩大，如果不是那就换一个字符。
     * 那就可以从第一个字符开始遍历整个字符串, 并且实现一个方法用来找以一个字符为起始其能找到的最长的回文串
     * 传入一个回文的左右索引，
     * 如果能左扩就扩左，判断是否回文，如果是回文的话则继续左扩直到不能扩，不是回文则继续执行
     * 如果能右扩就右扩，判断是否回文，如果是回文的话则继续右扩直到不能扩，不是回文则继续执行
     * 同时扩左右扩后，再判断是否为回文，如果是回文的话则继续同时左右扩，不是回文则继续执行
     * 如果能找到一个回文，那么再次以这个回文范围进行迭代
     * 如果找到多个回文，返回最长的
     *
     * */
    public String longestPalindrome(String s) {
        int[] longest = new int[]{0, 0};
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (isPalindrome(chars, i, j)) {
                    if (j - i > longest[1] - longest[0]) {
                        longest[0] = i;
                        longest[1] = j;
                    }
                }
            }
        }
        StringBuilder newSB = new StringBuilder();
        for (int i = longest[0]; i <= longest[1]; i++) {
            newSB.append(chars[i]);
        }
        return newSB.toString();
    }

    // 判断是否为回文
    public boolean isPalindrome(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] == s[right]) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return left >= right;
    }

    /*
     * 思路2:
     * 从回文的特点出发，回文的特点是中心对称
     * 那么就可以一个中心进行扩散判断，如果扩散还是回文那就继续扩散。
     * 中心有一个或者两个的情况，所以都需要处理。
     *
     * */
    public String longestPalindrome2(String s) {
        int[] longest = new int[]{0, 0};
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 中心只有一个
            int left = i, right = i;
            longest = getInts(longest, chars, left, right);
            // 两个中心
            left = i;
            right = i + 1;
            longest = getInts(longest, chars, left, right);
        }
        StringBuilder newSB = new StringBuilder();
        for (int i = longest[0]; i <= longest[1]; i++) {
            newSB.append(chars[i]);
        }
        return newSB.toString();
    }

    int[] getInts(int[] longest, char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            if (right - left > longest[1] - longest[0]) longest = new int[]{left, right};
            left--;
            right++;
        }
        return longest;
    }

    public String longestPalindrome3(String s) {
        // 设置一个固定大小的窗口，遍历该字符串，扩大窗口再次遍历
        // 只有字符串长度>1的时候才需要遍历判断，等于1的时候肯定是回文直接返回
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] longest = new int[]{0, 0};
        // 用一个map记录s[i,j]是否为回文
        boolean[][] pMap = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            pMap[i][i] = true; // 初始化一下单个字符的回文情况
        }
        // 用窗口遍历字符串
        for (int L = 2; L <= chars.length; L++) {
            for (int left = 0; left < chars.length - L + 1; left++) {
                // 窗口的左边界递增，代表着该长度的窗口持续右滑
                int right = left + L - 1; // 右编辑根据左边的位置推算得到
                // 判断该窗口中的子串是否为回文，解决动态规划的问题
                if (isPalindrome2(chars, pMap, left, right)) {
                    // 是回文的话记录一下
                    if (right - left > longest[1] - longest[0]) {
                        longest[0] = left;
                        longest[1] = right;
                    }
                }
            }
        }
        StringBuilder newSB = new StringBuilder();
        for (int i = longest[0]; i <= longest[1]; i++) {
            newSB.append(chars[i]);
        }
        return newSB.toString();
    }

    // 动态规划判断是否为回文, 存储每次计算得到的回文结果
    public boolean isPalindrome2(char[] s, boolean[][] map, int left, int right) {
        // map[left][right]是否为回文=>map[left+1][right-1]&&s[left]==s[right]
        // 边界情况1：right-left=1，只需要判断s[left]==s[right]
        // 边界情况2：right=left，一定是回文 初始化过了
        if (s[left] != s[right]) {
            map[left][right] = false;
            return false;
        } else {
            if (right - left == 1 || right == left) {
                map[left][right] = true;
            } else {
                map[left][right] = map[left + 1][right - 1];
            }
        }
        return map[left][right];
    }

    public static void main(String[] args) {
        Class5 class5 = new Class5();
        System.out.println(class5.longestPalindrome3("tattat"));
    }
}
