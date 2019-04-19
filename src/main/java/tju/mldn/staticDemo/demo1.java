package tju.mldn.staticDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:00
 * Email: clickgwas@gmail.com
 */
public class demo1 {
    public static void main(String args[]) {
        new Book("Java") ;	new Book("JSP") ;	new Book("Spring") ;
    }
}
class Book {
    private String title ;
    private static int count = 0 ;
    public Book(String title) {
        this.title = title ;
        count ++ ;
        System.out.println("第" + count + "本图书创建出来。") ;
    }
}