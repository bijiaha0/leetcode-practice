package Amazon.FindMedian;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Author: bijiaha0
 * Date: 2019-05-26
 * Time: 10:30
 * Email: clickgwas@gmail.com
 */
public class Solution {
}

class findMedian {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    findMedian() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((o1, o2) -> o2 - o1);

    }

    public void addNum(int num) {
        min.add(num);
        max.add(min.poll());
        if (max.size() > min.size()) {
            min.add(max.poll());
        }
    }

    public double getMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        return min.peek() / 1.0;
    }

    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}