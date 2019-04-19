package tju.basic_class_04.ceshi;

/**
 * Author: bijiaha0
 * Date: 2018-10-25
 * Time: 下午11:55
 * Email: clickgwas@gmail.com
 */
public class demo2 {
    public static void main(String[] args) {
        mf();
    }
    static demo2 st = new demo2();
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    demo2(){
        System.out.println("3");
        System.out.println("a="+ a +",b="+b);
    }
    public static  void mf(){
        System.out.println("4");
    }
    int a =110;
    static int b= 112;
}
