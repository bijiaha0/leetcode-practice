package Amazon.KthLargestInNArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/kth-largest-in-n-arrays/description
 * 对每个数组排序，然后将每个数组的最小元素加入到优先队列中，每次从优先队列中pop出一个元素，然后push进同组的下一个元素，直到第k个
 */
/*
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.
In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 4 and etc.
* */
class Node {
    public int value, from_id, index;
    public Node(int _v, int _id, int _i) {
        this.value = _v;
        this.from_id = _id;
        this.index = _i;
    }
}
public class Solution {
    public int KthInArrays(int[][] arrays, int k) {
        Queue<Node> queue =  new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o2.value-o1.value;
            }
        });
        int n = arrays.length;
        int i;
        for (i = 0; i < n; ++i) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                int from_id = i;
                int index = arrays[i].length - 1;
                int value = arrays[i][index];
                queue.add(new Node(value, from_id, index));
            }
        }
        for (i  = 0; i < k; ++i) {
            Node temp = queue.poll();
            int from_id = temp.from_id;
            int index = temp.index;
            int value = temp.value;
            if (i == k - 1)
                return value;
            if (index > 0) {
                index --;
                value = arrays[from_id][index];
                queue.add(new Node(value, from_id, index));
            }
        }
        return -1;
    }
}
