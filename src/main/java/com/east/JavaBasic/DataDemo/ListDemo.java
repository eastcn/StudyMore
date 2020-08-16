package com.east.JavaBasic.DataDemo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname ListDemo
 * @Description TODO
 * @Date 2020/8/13 2:23 下午
 * @Created by East
 */
public class ListDemo {
    public static void main(String[] args) {

//        List<Integer> integerList = List.of(1, 2, 3, 5); List.of()方法为JDK9的新特性
        List<Integer> integerList = Arrays.asList(1, 23, 45);
        // 通过循环 get()来遍历List
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }
        // 通过for each来遍历
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
        // 通过迭代器来遍历， for each 内部实现就是迭代器方法
        for (Iterator<Integer> iterator = integerList.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

        // List转化为Array
        // Object[] array = integerList.toArray(); 会使类型丢失，所以不常用。
        Integer[] array = integerList.toArray(new Integer[3]);
        for (Integer n : array) {
            System.out.println(n);
        }
        // Array 转化为List
        List<Integer> integerList1 = Arrays.asList(array);
        for (Integer a : integerList1) {
            System.out.println(a);
        }
        // 是否包含某个元素
        System.out.println(integerList.contains(1));
        // 查找某个元素的索引
        System.out.println(integerList.indexOf(23));


    }
}
