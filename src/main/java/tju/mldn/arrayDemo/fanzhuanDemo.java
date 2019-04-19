package tju.mldn.arrayDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:10
 * Email: clickgwas@gmail.com
 */
public class fanzhuanDemo {
    public static void main(String args[]) {
        int data [] = new int [] {1,2,3,4,5,6,7,8,9} ;
        ArrayUtil1.reverse(data) ;	// 转置处理
        ArrayUtil1.printArray(data) ;
    }
}
class ArrayUtil1 {
    public static void reverse(int data[]) {
        int center = data.length / 2 ; // 确定转换的次数
        int head = 0 ;	// 操作脚标
        int tail = data.length - 1 ; // 操作脚标
        for (int x = 0 ; x < center ; x ++) {
            int temp = data [head] ;
            data [head] = data [tail] ;
            data [tail] = temp ;
            head ++ ;
            tail -- ;
        }
    }
    public static void printArray(int temp []) {
        for (int x = 0 ; x < temp.length ; x ++) {
            System.out.print(temp[x] + "、") ;
        }
        System.out.println() ;
    }
}