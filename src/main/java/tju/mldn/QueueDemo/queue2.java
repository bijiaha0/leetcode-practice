package tju.mldn.QueueDemo;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午6:10
 * Email: clickgwas@gmail.com
 */
public class queue2 {
    public static void main(String[] args) throws Exception {
        Queue<String> queue = new PriorityQueue<String>() ;
        queue.offer("X") ;	// 追加队列数据，通过队尾追加
        queue.offer("A") ;	// 追加队列数据，通过队尾追加
        queue.offer("Z") ;	// 追加队列数据，通过队尾追加
        System.out.println(queue.poll()); // 弹出数据、X
        System.out.println(queue.poll()); // 弹出数据、A
        System.out.println(queue.poll()); // 弹出数据、Z
    }
}
