package com.east.LeetCode.problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/12/5
 */
class Solution {
    public boolean isValid(String s) {
        // 思路，这是一到判断是否对称的题，一般可以用栈来处理
        // 新建一个栈
        // 如果遇到左括号, 如: (、[、{ ，则放入右括号,如: )、]、}
        // 如果遇到栈为空或者pop出来的值跟当前的值不匹配，那么就是不对称
        // 因为，栈先进后出的特性，如果第一次遇到左括号，那么下一次先遇到的一定是对应的右括号也即pop出来的那个对应值
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('(' == c) stack.push(')');
            else if ('[' == c) stack.push(']');
            else if ('{' == c) stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        // 当所有的字符都遍历完，栈为空则字符串对称
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // 思路2 其实是一道对称题
        // 因为都是字符串，并且中心一定有一个左右括号对称
        // 所以可以通过不断消除中心对称的字符串来判断是否完全拿对称, 如果没有中心对称的括号了那就是不匹配
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }


    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println();
    }
}
