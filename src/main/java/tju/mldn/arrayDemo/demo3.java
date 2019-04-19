package tju.mldn.arrayDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:06
 * Email: clickgwas@gmail.com
 */
public class demo3 {
    public static void main(String args[]) {
        int data [][] = new int [][] {
                {1,2,3,4,5} , {1,2,3} , {5,6,7,8}} ;
        for (int x = 0 ; x < data.length ; x ++) {
            for (int y = 0 ; y < data[x].length ; y ++) {
                System.out.println("data["+x+"]["+y+"] = " + data[x][y]) ;
            }
            System.out.println() ;	// 换行
        }
    }
}
