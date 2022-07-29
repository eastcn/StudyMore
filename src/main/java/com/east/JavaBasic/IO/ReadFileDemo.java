package com.east.JavaBasic.IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Function: 读取文件的多种方法
 *
 * @author taihua
 * @date 2022/2/22
 */
public class ReadFileDemo {
    private static final String filePath = "src/main/resources/demoFile.txt";

    /**
     * scanner 模式读取文件 jdk1.5引入
     * 可以按行读取，也可以按分隔符读取。
     */
    public static void Demo1() throws FileNotFoundException {

        // 按行读取文件, Scanner 实现了Iterator接口方法, 所以可以像Iterator一样处理
        // 先通过FileReader获取到文件的字符流,然后再逐行读取
        // 其实可以理解为Scanner可能是更高级的BufferedReader, 其提供了更多的对字符流操作的方法，如正则等
        try (Scanner sc = new Scanner(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sb.append(line);
                System.out.println(line);
            }
        }
    }

    public static void Demo2() throws FileNotFoundException {
        // 设置分隔符
        try (Scanner sc = new Scanner(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            sc.useDelimiter("-");
            while (sc.hasNext()) {
                String str = sc.next();
                sb.append(str);
                System.out.println(str);
            }
        }
    }

    public static void Demo3() throws IOException {
        Files.lines(Paths.get(filePath)).forEach(System.out::println);
    }

    public static void Demo4() throws IOException {
        List<String> lineList = Files.readAllLines(Paths.get(filePath));
        for (String line : lineList
        ) {
            System.out.println(line);
        }
    }

    public static void Demo5() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 读取大文件的方法
    public static void Demo6() throws FileNotFoundException {
        // 直接用FileInputStream
        try (InputStream is = new FileInputStream(filePath)) {
            // 设置每次读取的大小 为4kb
            byte[] buffer = new byte[4096];
            int offset = 0;
            long count = 0;
            while ((offset = is.read(buffer)) != -1) {
                count = offset + count;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // bufferedInputStream
        InputStream is = new FileInputStream(filePath);
        try (BufferedInputStream bis = new BufferedInputStream(is)) {
            // 设置每次读取的大小 为4kb
            byte[] buffer = new byte[10240];
            int flag = 0; // 用于判断是否会读取到
            while ((flag = bis.read(buffer)) != -1) {
                // 现在读取到的,buffer就已经存了读取到的内容
                System.out.println(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读字符
        FileReader fr = new FileReader(filePath);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // nio 方法
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            FileChannel fileChannel = fileInputStream.getChannel();

            int capacity = 1 * 1024 * 1024;//1M
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
            StringBuffer buffer = new StringBuffer();
            while (fileChannel.read(byteBuffer) != -1) {
                //读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                String str = new String(bytes);
                //System.out.println(str);
                //处理字符串,并不会将字符串保存真正保存到内存中
                // 这里简单模拟下处理操作.
                buffer.append(str.substring(0, 1));
            }
            System.out.println("buffer.length:" + buffer.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Demo5();
    }
}
