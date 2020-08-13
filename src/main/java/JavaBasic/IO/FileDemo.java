package JavaBasic.IO;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Classname FileDemo
 * @Description TODO
 * @Date 2020/8/13 5:55 下午
 * @Created by East
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        String path = "/Users/hefeng/Project/Java/HogwartsStudy/src/main/resources/demoFile.txt";
        File file = new File(path);
        System.out.println("绝对路径：" + file.getAbsolutePath()); // getAbsolutePath
        System.out.println("规范路径：" + file.getCanonicalPath()); // getCanonicalPath
        System.out.println("构造方法传入的路径：" + file.getPath()); // getPath

        // isFile判断是否存在
        System.out.println("文件是否存在：" + file.isFile());
        // isDirector 判断是否为文件夹
        System.out.println("是否为文件夹：" + file.isDirectory());
        // 判断文件权限
        System.out.println("文件是否可读：" + file.canRead());
        System.out.println("文件是否执行：" + file.canExecute());
        System.out.println("文件是否可写：" + file.canWrite());
        // 文件创建和删除
        File file1 = new File("/Users/hefeng/Project/Java/HogwartsStudy/src/main/resources/demoFileTemp.txt");
        System.out.println("创建文件：" + file1.createNewFile());
        System.out.println("删除文件：" + file1.delete());
        // 创建临时文件，在执行后自动删除
        File file2 = File.createTempFile("tmp1_", "txt");
//        File file3 = File.createTempFile("temp2_", "txt"); // 不设置deleteOnExit
        file2.deleteOnExit(); // 退出JVM时删除
        // 遍历文件夹
        File director = new File("/Users/hefeng/my/");
        System.out.println("文件夹中的目录：" + Arrays.toString(director.list()));
        System.out.println("文件夹中的文件的路径：" + Arrays.toString(director.listFiles()));
        // 设置文件过滤
    }
}
