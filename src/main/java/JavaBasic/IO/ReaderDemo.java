package JavaBasic.IO;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Classname ReaderDemo
 * @Description ReaderDemo, 与InputStream的区别在于，前者是char类型的操作，后者是byte类型的操作
 * @Date 2020/8/13 11:28 下午
 * @Created by East
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String path1 = "/Users/hefeng/Project/Java/HogwartsStudy/src/main/resources/demoFile.txt";

        // Reader是所有reader类的超类，是一个抽象类
        URL path = ReaderDemo.class.getResource("demoFile.txt");
        // FileReader实例化需要一个File对象
//        Reader reader = new InputStreamReader(ReaderDemo.class.getResourceAsStream("demoFile.txt"));
        Reader reader = new FileReader(path1); // jdk11中引入可以指定编码格式
        // InputStreamReader 可以传入指定编码
        Reader reader1 = new InputStreamReader(new FileInputStream(path1), StandardCharsets.UTF_8);
        int n;
        while ((n = reader1.read()) != -1) {
            System.out.println(n);
        }
        // StringReader 可以直接把String作为数据源
        Reader stringReader = new StringReader("Hello World");
        int m;
        while ((m = stringReader.read()) != -1) {
            System.out.println(m);
        }

    }
}
