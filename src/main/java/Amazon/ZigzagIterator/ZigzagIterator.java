package Amazon.ZigzagIterator;

import java.util.Iterator;
import java.util.List;

/**
 * Time: 14:29
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solution/zigzag-iterator/
 * 双指针水题，用双指针求解即可，交叉返回两数组当前位置的数，当一个数组被访问完后，就一直访问另一个数组
 */
public class ZigzagIterator {
    public Iterator<Integer> it1;
    public Iterator<Integer> it2;
    public int turns;

    /**
     * @param v1 v2 two 1d vectors
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        turns = 0;
    }

    public int next() {
        // Write your code here
        turns++;
        if((turns % 2 == 1 && it1.hasNext()) || (!it2.hasNext())) {
            return it1.next();
        } else if((turns % 2 == 0 && it2.hasNext()) || (!it1.hasNext())) {
            return it2.next();
        }
        return -1;
    }

    public boolean hasNext() {
        // Write your code here
        return it1.hasNext() || it2.hasNext();
    }
}
