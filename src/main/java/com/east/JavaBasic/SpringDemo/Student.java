package com.east.JavaBasic.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2020/8/31 10:21 下午
 * @Created by East
 */
public class Student {
    @Autowired
    private int age;
    @Autowired
    private String name;

    public int getAge() {
        return age;
    }
}
