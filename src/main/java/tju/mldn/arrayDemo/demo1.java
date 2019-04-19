package tju.mldn.arrayDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:04
 * Email: clickgwas@gmail.com
 */
public class demo1 {
    public static void main(String args[]) {
        // 使用数组的静态初始化
        int data [] = new int [3] ;
        data [0] = 10 ;	// 为数组设置内容
        data [1] = 20 ;	// 为数组设置内容
        data [2] = 30 ;	// 为数组设置内容
        for (int x = 0 ; x < data.length ; x ++) {
            System.out.println(data[x]) ;
        }
    }
}
