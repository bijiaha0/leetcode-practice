package tju.mldn.colllectionDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午6:00
 * Email: clickgwas@gmail.com
 */
public class mapDemo1 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<String,Integer>() ;
        map.put("one", 1) ;
        map.put("two", 2) ;
        map.put("one", 101) ;	// key重复
        map.put(null, 0) ;		// key为null
        map.put("zero", null) ; // value为null
        System.out.println(map.get("one"));	// key存在
        System.out.println(map.get(null));	// key存在
        System.out.println(map.get("ten"));	// key不存在
    }
}
