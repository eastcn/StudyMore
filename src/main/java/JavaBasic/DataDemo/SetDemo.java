package JavaBasic.DataDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Classname SetDemo
 * @Description TODO
 * @Date 2020/8/13 4:31 下午
 * @Created by East
 */
public class SetDemo {
    public static void main(String[] args) {
        // Set 用于存储不重复的数据,HashSet 为最常用的实现类，HashSet是无序的因为没有实现SortedSet接口，TreeSet是有序的
        Set<String> set = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            set.add("Hash No." + i);
            treeSet.add("Tree No." + i);
        }

        for (String x : set) {
            // 输出结果可见，hashset是无序的
            System.out.println(x);
        }
        for (String tree : treeSet
        ) {
            // tree set是有序的
            System.out.println(tree);
        }
    }
}
