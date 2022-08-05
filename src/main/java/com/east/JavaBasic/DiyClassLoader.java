package com.east.JavaBasic;

/**
 * Function:
 *
 * @author taihua
 * @date 2022/8/3
 */
public class DiyClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前ClassLoader " + classLoader);
        System.out.println("当前ClassLoader的父类 " + classLoader.getParent());
        System.out.println("父类的父类 " + classLoader.getParent().getParent());
    }
}