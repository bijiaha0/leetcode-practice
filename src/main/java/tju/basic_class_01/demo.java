package tju.basic_class_01;

/**
 * Author: bijiaha0
 * Date: 2018-09-26
 * Time: 下午7:31
 * Email: clickgwas@gmail.com
 */
public class demo {
    public static void main(String[] args) {
        int a[]={1,2,3};
        int i[]={1,2,3};
        a[1]=i[1]=10;
        System.out.println(a[1]+ " "+i[1]);
    }
}
