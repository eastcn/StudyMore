package com.east.LeetCode.OfferProlem;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 判断是否为数值
 *
 * @author taihua
 * @date 2022/8/4
 */
public class Offer20 {
    /*
    思路1：有限状态自动机
                // 空格：1，数字：2，小数点：3，e/E：4，符号：5
                // 0: 空格状态，可以进入0、1、2、8
                // 1: 符号，可以进入2、8
                // 2: 小数点前整数, 2,4,5,8
                // 3: 小数点后以及小数点后的整数,可以进入3、4,7
                // 4: e/E，可以进入5、6
                // 5: e/E后的符号可以进入6
                // 6: e/E后的整数可以进入6,7
                // 7:
                // 8: 较特殊状态，当前面是空格时遇到小数点时的状态，可以进入3
                // key 代表遇到的 字符类型，value代表下一个状态
     */
    public boolean isNumber(String s) {
        HashMap[] states = {
                new HashMap<Integer, Integer>() {{
                    put(5, 1);
                    put(2, 2);
                    put(3, 8);
                    put(1, 0);
                }}, // 0
                new HashMap<Integer, Integer>() {{
                    put(2, 2);
                    put(3, 8);
                }}, // 1
                new HashMap<Integer, Integer>() {{
                    put(2, 2);
                    put(3, 3);
                    put(4, 4);
                    put(1, 7);
                }},// 2
                new HashMap<Integer, Integer>() {{
                    put(2, 3);
                    put(1, 7);
                    put(4, 4);
                }}, // 3
                new HashMap<Integer, Integer>() {{
                    put(2, 6);
                    put(5, 5);
                }}, // 4
                new HashMap<Integer, Integer>() {{
                    put(2, 6);
                }}, // 5
                new HashMap<Integer, Integer>() {{
                    put(2, 6);
                    put(1, 7);
                }}, // 6
                new HashMap<Integer, Integer>() {{
                    put(1, 7);
                }}, // 7
                new HashMap<Integer, Integer>() {{
                    put(2, 3);
                }}// 8
        };
        char[] chars = s.toCharArray();
        int state = 0; // 初始状态
        for (char c : chars) {
            int type = getType(c);
            HashMap map = states[state]; // 表示当前状态可以进入的后续状态
            state = (int) map.getOrDefault(type, 9);
            if (state > 8) {
                break;
            }
        }
        return state == 2 || state == 3 || state == 6 || state == 7;
    }

    int getType(char c) {
        if (c == ' ')
            return 1;
        else if (c - '0' <= 9 && c - '0' >= 0)
            return 2;
        else if (c == '.')
            return 3;
        else if (c == 'e' || c == 'E')
            return 4;
        else if (c == '+' || c == '-')
            return 5;
        else
            return 6;
    }

    public static void main(String[] args) {
        Offer20 o = new Offer20();
        System.out.println(o.isNumber("3."));
    }
}
