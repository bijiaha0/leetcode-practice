package Amazon.TopKLargestNumbers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class Solution1 {
    public List<Integer> topk(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(k);
        for (int i : nums) {
            minheap.add(i);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        List<Integer> res = new ArrayList<>(minheap);
        Collections.reverse(res);
        return res;
    }
}
