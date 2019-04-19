package SuanFaNeiGong.Heap.IndexHeapAdvance;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Author: bijiaha0
 * Date: 2019-03-10
 * Time: 17:49
 * Email: clickgwas@gmail.com
 */
public class ceshi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String s = "";
        while (nextLine != null &&! nextLine.equals("")){
            s = nextLine;
            nextLine =scanner.nextLine() ;
        }
        solve(s);
        System.out.println(solve(s));
    }
    public static  String solve(String s){
        String res = "";
        s = s.toLowerCase();
        LinkedHashSet<Character> objects = new LinkedHashSet<>();
        for(int i =0; i < s.length(); i++){
            if(objects.contains(s.charAt(i))){
                objects.remove(s.charAt(i));
            }
            objects.add(s.charAt(i));
        }
        Iterator<Character> iterator = objects.iterator();
        while (iterator.hasNext()){
            res += iterator.next();
        }
        return  res;
    }
}
