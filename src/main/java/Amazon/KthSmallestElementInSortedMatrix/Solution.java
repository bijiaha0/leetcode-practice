package Amazon.KthSmallestElementInSortedMatrix;
import java.util.PriorityQueue;
import java.util.Queue;
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int cnt = 0;
        // 默认是小跟堆
        Queue<int[]> heap = new PriorityQueue<>();
        heap.offer(new int[]{0, 0});
        while (true) {
            int[] pair = heap.poll();
            if (++cnt == k) {
                return matrix[pair[0]][pair[1]];
            }
            if (pair[0] == 0 && pair[1] + 1 < matrix[0].length) {
                heap.offer(new int[]{0, pair[1] + 1});
            }
            if (pair[0] + 1 < matrix.length) {
                heap.offer(new int[]{pair[0] + 1, pair[1]});
            }
        }
    }
}