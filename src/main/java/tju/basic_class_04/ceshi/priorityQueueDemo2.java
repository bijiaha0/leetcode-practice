package tju.basic_class_04.ceshi;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: bijiaha0
 * Date: 2018-11-23
 * Time: 12:05 PM
 * Email: clickgwas@gmail.com
 */
public class priorityQueueDemo2 {
    public static class doubleComparator implements Comparator<Double> {
        @Override
        public int compare(Double o1, Double o2) {
            if(o1 < o2 ){
                return 1;
            }else if (o1 > o2 ){
                return -1;//-1放在前头
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /*
         * 如果你已经加了N个数，
         * 弹出一个数的代价是O(logN)的，
         * 加一个数的代价也是O(logN)的，
         * 因为完全二叉树的高度就是O(logN)的
         * */
        PriorityQueue<Double> heap = new PriorityQueue<Double>(new doubleComparator());//默认是小跟堆，头顶的是最小值
        FileInputStream fisT = new  FileInputStream("/Users/student/Desktop/combineColumnsFilesDelete/exp/luad_N.txt");   //盘符不分大小写
        Reader rT = new InputStreamReader(fisT,"utf-8");
        BufferedReader brT = new BufferedReader(rT);
        brT.readLine();//先读取一行
        String lineT;
        while((lineT=brT.readLine())!=null){   //一次读一行
            String[] split = lineT.split(" ");
            for(int jj = 0;jj < split.length; jj++){
                heap.add(Double.valueOf(split[jj]));
            }
        }
        Double value = heap.poll();
        System.out.println(value);
    }

}
