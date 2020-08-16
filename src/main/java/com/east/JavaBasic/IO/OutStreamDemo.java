package com.east.JavaBasic.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Classname OutStreamDemo
 * @Description OutSteam 是Java中标准输出流的基本类，是所有输出流的超类，是抽象类
 * @Date 2020/8/13 10:28 下午
 * @Created by East
 */
public class OutStreamDemo {
    public static void main(String[] args) throws IOException {
        String path = "/Users/hefeng/Project/Java/HogwartsStudy/src/main/resources/outputDemo.txt";

        OutputStream ot = new FileOutputStream(path); // 若文件不存在会抛出FileNotFoundException
        ot.write("hello world".getBytes()); // 会抛出IOException
        ot.close();
        //  跟InputStream一样
        try (OutputStream output = new FileOutputStream(path)) {
            output.write("Hello".getBytes(StandardCharsets.UTF_8)); // Hello
        } // 编译器在此自动为我们写入finally并调用close()
    }

}
