package Amazon.LargestRectangleinHistogram;
import java.util.Stack;
//绝对的单调增
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - (stack.peek() + 1);
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }
}
