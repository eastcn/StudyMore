package com.east.LeetCode.Top;

import java.util.Stack;

/**
 * Function: 括号的有效性
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author taihua
 * @date 2024/2/19
 */
public class Class2 {
    static public boolean isValid(String s) {
        /*
         * 思路1
         * 关键点在于顺序和左右的全匹配
         * 顺序：先出现的左括号要后匹配其右括号，即先进后出，所以可以用栈的结构
         * 全匹配：出现过的左括号要全有其匹配的右括号，出现的右括号要能找到其匹配的左括号
         * 综上得到一个思路是：
         * 创建一个栈
         * 遍历字符数组，遇到左括号则放入栈，遇到右括号则从栈顶取括号，如果不匹配或者栈空了，则不合法，如果匹配则进行下一次循环
         * 循环结束查看栈是否为空，如果为空则匹配，不为空则不匹配
         *
         * 思路1的优化，遇到左括号时把对应的右括号放入栈，后续遇到右括号时可以减少判断
         * */
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (curChar == '(' || curChar == '[' || curChar == '{') {
                stack.push(curChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if ((curChar == ')' && c != '(') || (curChar == ']' && c != '[') || (curChar == '}' && c != '{')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
// 优化
//        Stack<Character> stack = new Stack();
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char curChar = chars[i];
//            if (curChar == '(') {
//                stack.push(')');
//            } else if (curChar == '[') {
//                stack.push(']');
//            } else if (curChar == '{') {
//                stack.push('}');
//            } else {
//                // 根据题目，非以上3种那么都是右括号了
//                if (stack.isEmpty() || stack.pop() != curChar) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
