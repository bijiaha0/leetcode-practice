package Amazon.TopKLargestNumbers;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * base on heap
 * https://www.jiuzhang.com/solutions/top-k-largest-numbers/
 * 前K大的数
 */
public class Solution1 {

    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i : nums) {
            minheap.add(i);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[k - i - 1] = minheap.poll();//从大往小排
        }
        return result;
    }

}
