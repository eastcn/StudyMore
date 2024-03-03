package com.east.LeetCode.Top;

import java.util.Stack;

public class Class20 {
    /**
     思路1： 一个栈作为输入栈，一个栈作为输出栈
     当输出栈为空的时候，从输入栈内拿一遍数据放到输出栈里面

     */
    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();

    public Class20() {

    }

    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if(stackB.isEmpty()){
            int x;
            while(!stackA.isEmpty()){
                x = stackA.pop();
                stackB.push(x);
            }

        }
        return stackB.pop();
    }

    public int peek() {
        if(stackB.isEmpty()){
            int x;
            while(!stackA.isEmpty()){
                x = stackA.pop();
                stackB.push(x);
            }
        }
        return stackB.peek();
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
