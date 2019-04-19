package tju.basic_class_04;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: bijiaha0
 * Date: 2018-09-07
 * Time: 下午6:49
 * Email: clickgwas@gmail.com
 */
/*
* 小跟堆(默认)和大根堆
* */
public class priorityQueueDemo {
    public static class student{
        private int id;
        private int age;

        public student(int id, int age) {
            this.id = id;
            this.age = age;
        }
    }

    public static class studentComparator implements Comparator<student>{
        @Override
        public int compare(student o1, student o2) {
            if(o1.age<o2.age){
                return -1;//谁小谁放到上头或者前头
            }else if (o1.age>o2.age){
                return 1;
            }else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        /*
        * 如果你已经加了N个数，
        * 弹出一个数的代价是O(logN)的，
        * 加一个数的代价也是O(logN)的，
        * 因为完全二叉树的高度就是O(logN)的
        * */
        PriorityQueue<student> heap = new PriorityQueue<student>(new studentComparator());//默认是小跟堆，头顶的是最小值
        heap.add(new student(1,17));
        heap.add(new student(4,3));
        heap.add(new student(5,19));
        heap.add(new student(2,73));
        heap.add(new student(3,84));
        while (!heap.isEmpty()){
            student student = heap.poll();
            System.out.println(student.id+","+student.age);
        }

    }
}
