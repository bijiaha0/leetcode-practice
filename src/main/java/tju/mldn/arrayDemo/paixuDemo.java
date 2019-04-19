package tju.mldn.arrayDemo;
/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:09
 * Email: clickgwas@gmail.com
 */
public class paixuDemo {
    public static void main(String args[]) {
        int data [] = new int [] {8,9,0,2,3,5,10,7,6,1} ;
        ArrayUtil.sort(data) ;	// 排序
        ArrayUtil.printArray(data) ;
    }
}
class ArrayUtil {
    public static void sort(int data[]) {	// 进行数组的排序处理
        for (int x = 0 ; x < data.length ; x ++) {
            for (int y = 0 ; y < data.length - x - 1 ; y ++) {
                if (data[y] > data[y + 1]) {	// 交换数据
                    int temp = data[y] ;
                    data[y] = data[y + 1] ;
                    data[y + 1] = temp ;
                }
            }
        }
    }
    public static void printArray(int temp []) {
        for (int x = 0 ; x < temp.length ; x ++) {
            System.out.print(temp[x] + "、") ;
        }
        System.out.println() ;
    }
}

