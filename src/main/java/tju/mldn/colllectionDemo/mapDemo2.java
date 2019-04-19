package tju.mldn.colllectionDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午6:05
 * Email: clickgwas@gmail.com
 */
public class mapDemo2 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        Set<Map.Entry<String,Integer>> set = map.entrySet() ;	// 将Map集合变为Set集合
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
