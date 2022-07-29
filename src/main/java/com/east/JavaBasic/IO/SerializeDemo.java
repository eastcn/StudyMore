package com.east.JavaBasic.IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @Classname SerializeDemo
 * @Description 序列化Demo
 * @Date 2020/8/13 11:24 下午
 * @Created by East
 */
public class SerializeDemo {
    public static void main(String[] args) {
        String str = "测试序列化";

        ByteArrayOutputStream demo = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(demo)) {
            out.writeUTF("测试序列化");
            out.writeInt(123);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(demo.toByteArray()));
    }

}
