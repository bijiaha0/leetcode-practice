package LeetCode.MaxConsecutiveOnesII;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int max(int[] arr, int k) {
        int res = 0;
        int start = 0;
        int end = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while (end<arr.length){
            if(arr[end]==1){
                end++;
            }else {
                if(deque.size()<k){
                    deque.addLast(end++);
                }else {
                    start = deque.pollFirst()+1;
                }
            }
            res = Math.max(res,end-start);
        }
        return res;
    }
}
