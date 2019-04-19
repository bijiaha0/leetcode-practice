package tju.mldn.arrayDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:07
 * Email: clickgwas@gmail.com
 */
public class demo4 {
    public static void main(String args[]) {
        int data [][] = new int [][] {
                {1,2,3,4,5} , {1,2,3} , {5,6,7,8}} ;
        for (int temp [] : data) {
            for (int num : temp) {
                System.out.print(num + "、") ;
            }
            System.out.println() ;
        }
    }
}
