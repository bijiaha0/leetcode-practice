package LeetCode.TryWithStack;

import java.util.ArrayDeque;
import java.util.Deque;
//单调递减栈
public class Solution2 {
    public int trap(int[] arr) {
        int res = 0;
        if (arr == null || arr.length <= 2) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            while (!stack.isEmpty()&&stack.peekLast()<cur){
                int index = stack.pollLast();
                if(!stack.isEmpty()){
                    int height = Math.min(cur,arr[stack.peekLast()]);
                    res+=(height-arr[index])*(i-stack.peekLast()-1);
                }
            }
            stack.addLast(i);
        }
        return res;
    }


}
