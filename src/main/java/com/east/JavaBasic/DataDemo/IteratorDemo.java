package com.east.JavaBasic.DataDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Function: Iterator 迭代器的使用Demo
 *
 * @author taihua
 * @date 2022/2/21
 */
public class IteratorDemo {
    // 使用 Iterator 遍历一个数组
    public static void main(String[] args) {
        List<String> demoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            demoList.add("demo_" + i);
        }
        // 实例化一个Iterator
        Iterator<String> it = demoList.iterator();
        // hasNext() 判断是否当前迭代器是否还含有下一个元素
        while (it.hasNext()) {
            // next() 取出迭代器的下一个元素，并将当前迭代器的cursor改为下一个元素，并把lastRef设置为cursor
            String demo = it.next();
            System.out.println(demo);
            if (demo.equals("demo_5")) {
                System.out.println("删除demo_5");
                // remove() 删除当前元素, 取数据时用的时cursor, remove时用的时lastRef
                // 不能直接使用remove()，因为lastRef的默认值为-1，如果没有使用next()进行取值，则lastRef为-1，使用remove()会抛出IllegalStateException
                it.remove();
            }
        }
        System.out.println("args = " + Arrays.toString(demoList.toArray()));
    }
}
