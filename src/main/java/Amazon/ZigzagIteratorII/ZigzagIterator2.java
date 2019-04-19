package Amazon.ZigzagIteratorII;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: bijiaha0
 * Date: 2019-03-09
 * Time: 14:30
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solution/zigzag-iterator-ii/
 */
public class ZigzagIterator2 {

    public List<Iterator<Integer>> its;
    public int turns;

    /**
     * @param vecs a list of 1d vectors
     */
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // initialize your data structure here.
        this.its = new ArrayList<Iterator<Integer>>();
        for (List<Integer> vec : vecs) {
            if (vec.size() > 0)
                its.add(vec.iterator());
        }
        turns = 0;
    }

    public int next() {
        // Write your code here
        int elem = its.get(turns).next();
        if (its.get(turns).hasNext())
            turns = (turns + 1) % its.size();
        else {
            its.remove(turns);
            if (its.size() > 0)
                turns %= its.size();
        }
        return elem;
    }

    public boolean hasNext() {
        // Write your code here
        return its.size() > 0;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
