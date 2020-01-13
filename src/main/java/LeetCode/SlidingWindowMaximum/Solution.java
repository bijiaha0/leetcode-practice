package LeetCode.SlidingWindowMaximum;
import java.util.ArrayDeque;
import java.util.Deque;
/*
* https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
* */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];
        int rIndex=0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i < nums.length; i++){
            while (!deque.isEmpty()&&deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i-k+1==0){
                res[rIndex++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
