package com.east.LeetCode.OfferProlem.offerProblem05;

/**
 * @Classname ReplaceSpace
 * @Description TODO
 * @Date 2020/8/19 9:15 下午
 * @Created by East
 */
public class ReplaceSpace {
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
//        return s.replace(" ","%20"); // 何必造轮子？
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("1 2 3 4 5 6 "));
    }
}
