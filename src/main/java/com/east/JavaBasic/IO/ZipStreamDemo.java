package com.east.JavaBasic.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Classname ZipStreamDemo
 * @Description 对zip文件的操作
 * @Date 2020/8/13 10:40 下午
 * @Created by East
 */
public class ZipStreamDemo {

    public static void main(String[] args) throws IOException {
        String path = "";
        // ZipInputStream 实例化通常需要传入一个FileInputStream作为数据源
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(path));
        ZipEntry entry = null;
        // 通过getNextEntry() 来获取下一个zip对象（目录或压缩文件），如果为文件则可用read()来读取内容
        while ((entry = zipInputStream.getNextEntry()) != null){
            if (!entry.isDirectory()){
                System.out.println(zipInputStream.read());
            }
        }
    }
}
