package tju.mldn.colllectionDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:59
 * Email: clickgwas@gmail.com
 */
public class iteratorDemo {
    public static void main(String[] args) throws Exception {
        Set<String> all = new HashSet<String>();
        all.add("Hello") ;
        all.add("World") ;
        all.add("MLDN") ;
        Iterator<String> iter = all.iterator() ; // 实例化Iterator接口对象
        while (iter.hasNext()) {
            String str = iter.next() ;
            if ("World".equals(str)) {
                iter.remove() ; // 删除当前的数据
            } else {
                System.out.println(str);
            }
        }
        System.out.println("*** " + all);
    }
}
