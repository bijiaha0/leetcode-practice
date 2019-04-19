package tju.mldn.StackDemo;

import java.util.Stack;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午6:08
 * Email: clickgwas@gmail.com
 */
public class stack1 {
    public static void main(String[] args) throws Exception {
        Stack<String> all = new Stack<String>() ;
        all.push("A") ;
        all.push("B") ;
        all.push("C") ;
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());	// 无数据、EmptyStackException
    }
}
