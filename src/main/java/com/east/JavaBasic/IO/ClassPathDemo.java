package com.east.JavaBasic.IO;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname ClassPathDemo
 * @Description 从classpath中获取文件
 * @Date 2020/8/13 11:20 下午
 * @Created by East
 */
public class ClassPathDemo {
    public static void main(String[] args) {
        // 通过class.getResourceAsStream() 方法可以获取到classpath中的文件
        try (InputStream inputStream = ClassPathDemo.class.getResourceAsStream("demoFile.txt")) {
            byte[] buffer = new byte[1000];
            System.out.println(inputStream.read(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
