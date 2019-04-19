package Amazon.DataStreamMedian;
import java.util.Collections;
import java.util.PriorityQueue;
/*
* https://www.jiuzhang.com/solutions/data-stream-median/
* */
public class Solution {
    PriorityQueue<Integer> maxHeap, minHeap;
    public int[] medianII(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        maxHeap = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(n);
        int i;
        for (i = 0; i < n; ++i) {
            if (maxHeap.size() == 0 || A[i] <= maxHeap.peek()) {//大跟堆放的是小于
                maxHeap.offer(A[i]);
            }
            else {
                minHeap.offer(A[i]);
            }
            balance();
            res[i] = maxHeap.peek();
        }
        return res;
    }
    private void balance() {
        while (maxHeap.size() < minHeap.size()) {//maxHeap.size() = minHeap.size()或者是maxHeap.size()-1 = minHeap.size()
            maxHeap.offer(minHeap.poll());
        }
        while (minHeap.size() < maxHeap.size() - 1) {//minHeap.size() = maxHeap.size() - 1 或者 minHeap.size() -1 = maxHeap.size() - 1
            minHeap.offer(maxHeap.poll());
        }
    }
}
