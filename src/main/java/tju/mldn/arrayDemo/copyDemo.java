package tju.mldn.arrayDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:14
 * Email: clickgwas@gmail.com
 */
public class copyDemo {
    public static void main(String args[]) {
        int dataA [] = new int [] {1,2,3,4,5,6,7,8,9} ;
        int dataB [] = new int [] {11,22,33,44,55,66,77,88,99} ;
        System.arraycopy(dataA,5,dataB,3,3) ;
        ArrayUtil.printArray(dataB) ;
    }
}
