package Amazon.LargestRectangleinHistogram;
import java.util.Stack;
/*
* https://www.lintcode.com/problem/largest-rectangle-in-histogram/solution
* */
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;//计算宽度，右边比它小的元素的索引是i，左边比它小的索引是stack.peek()。
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
