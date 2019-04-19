package tju.mldn.arrayDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:05
 * Email: clickgwas@gmail.com
 */
public class demo2 {
    public static void main(String args[]) {
        int data [] = new int [] {1,2,3,4,5} ;
        for (int temp : data) {	// 自动循环，将data数组每一个内容交给temp
            System.out.println(temp) ;
        }
    }
}
