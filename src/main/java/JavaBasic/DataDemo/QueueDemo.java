package JavaBasic.DataDemo;

import java.util.*;

/**
 * @Classname Queue
 * @Description TODO
 * @Date 2020/8/13 4:40 下午
 * @Created by East
 */
public class QueueDemo {

    public static void main(String[] args) {
        // 队列，即一个遵循FIFO（First In First Out）的列表

        Queue<String> q = new LinkedList<String>();
        // add/offer 添加一个元素在末尾
        for (int i = 0; i < 5; i++) {
            q.add("NoAdd." + i);
            q.offer("NoOffer." + i);
        }
        for (String i : q
        ) {
            System.out.println(i);
        }
        // peek()/element() 获取首个但不删除
        System.out.println(q.peek());
        // remove/poll获取第一个元素并从queue中删除
        System.out.println(q.remove());
        System.out.println(q.poll());
        System.out.println(q);

        // PriorityQueue, 有优先级的队列，可以实现优先级高的在队首,需要实现一个Comparator接口
        Queue<Integer> pq = new PriorityQueue<>(new Compare());
        for (int i = 0; i < 4; i++) {
            pq.offer(i);
        }
        System.out.println(pq.peek());
    }

    static class Compare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return -1;// 返回-1 则优先级高
            }else {
                return 0;
            }
        }
    }
}
