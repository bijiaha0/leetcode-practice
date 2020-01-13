package LeetCode.LargestRectangleInHistogram;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/O(n)-stack-based-JAVA-solution
 */
public class Solution {
    public int largestRectangleInHistogram(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        Deque<Integer> stack= new ArrayDeque<>();
        for (int i = 0; i <= arr.length; i++) {
            int curVal = i == arr.length ? 0 : arr[i];
            while (!stack.isEmpty() && arr[stack.peekLast()] >= curVal) {
                int height = arr[stack.pollLast()];
                int left = stack.isEmpty() ? -1 : stack.peekLast();
                max = Math.max(max, (i - left-1) * height);
            }
            stack.addLast(i);
        }
        return max;
    }
}
