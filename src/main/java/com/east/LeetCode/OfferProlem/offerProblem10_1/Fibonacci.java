package com.east.LeetCode.OfferProlem.offerProblem10_1;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/7/29
 */
public class Fibonacci {
    public int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return solution(n - 1) + solution(n - 2);
        }
    }

    public int fib(int n) {
        int m = 1000000007;
        if (n < 2) {
            return n;
        }
        // 从f0和f1开始加
        int fn = 0;
        int fn_2 = 0; // f(n-2) 初始值为 f(0) = 0
        int fn_1 = 1; // f(n-1) 初始值为 f(1) = 1
        for (int i = 2; i <= n; i++) {
            // 对结果取模
            fn = (fn_1 + fn_2) % m;
            // 下一轮循环的 f(n-1) = 本轮的f(n), 下一轮的f(n-2) = 本轮的f(n-1)
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Fibonacci x = new Fibonacci();
        System.out.println(x.fib(3));
        System.out.println(x.solution(3));
    }
}
