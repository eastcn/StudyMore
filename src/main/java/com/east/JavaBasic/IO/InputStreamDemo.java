package com.east.JavaBasic.IO;

import java.io.*;

/**
 * @Classname InputStreamDemo
 * @Description TODO
 * @Date 2020/8/13 10:09 下午
 * @Created by East
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        // InputStream 是所有输入流的超类，是一个抽象类
        String path = "/Users/hefeng/Project/Java/HogwartsStudy/src/main/resources/demoFile.txt";
        // FileInputStream 是InputStream的子类，用于读取文件流中数据
        InputStream is = new FileInputStream(path); // FileInputStream 会丢出一个FileNotFoundException，是IOException的子类
        int n = 0;
        // InputStream.read()会一直读取文本中的下一个字节，如果读完了则返回-1
        do {
            n = is.read();
            System.out.println(n);
        } while (n != -1);
        // 通过InputSteam.close()来关闭流，释放底层资源
        is.close();

        // jdk7  引入特性, 使用try(){} 可以自动检查类是否实现AutoCloseable接口，如果实现则会默认在try后面加上finally{close}语句
        // inputStream和outputStream都实现了java.lang.AutoCloseable接口

        // 缓冲读取: read(byte[] b) 读取一定缓存数量的数据到缓冲数组中
        try (InputStream is1 = new FileInputStream(path)) {
            byte[] buffer = new byte[1000];
            int m;
            while ((m = is1.read(buffer)) != -1) {
                System.out.println("read " + m + " bytes.");
            }
        }
    }
}
