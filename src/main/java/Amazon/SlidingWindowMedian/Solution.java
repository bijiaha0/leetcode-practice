package Amazon.SlidingWindowMedian;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class Solution {
    PriorityQueue<Integer> maxHeap, minHeap;
    public List<Integer> medianSlidingWindow(int[] A, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        if (n == 0) {
            return res;
        }

        maxHeap = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(n);

        int i;
        for (i = 0; i < n; ++i) {
            if (maxHeap.size() == 0 || A[i] <= maxHeap.peek()) {
                maxHeap.offer(A[i]);
            }
            else {
                minHeap.offer(A[i]);
            }

            balance();
            if (i - k >= 0) {
                if (A[i - k] > maxHeap.peek()) {
                    minHeap.remove(A[i - k]);
                }
                else {
                    maxHeap.remove(A[i - k]);
                }
            }

            balance();

            if (i >= k - 1) {
                res.add(maxHeap.peek());
            }
        }
        return res;
    }

    private void balance() {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

}

