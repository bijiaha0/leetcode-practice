package Amazon.FindPeakElementII;

import java.util.ArrayList;
import java.util.List;
/*
* https://www.lintcode.com/problem/find-peak-element-ii/description
* 寻找峰值
* */
public class Solution {

    public List<Integer> findPeakII(int[][] A) {
        // this is the nlog(n) method
        int low = 1, high = A.length-2;
        List<Integer> ans = new ArrayList<Integer>();
        while(low <= high) {
            int mid = (low + high) / 2;
            int col = find(mid, A);
            if(A[mid][col] < A[mid - 1][col]) {
                high = mid - 1;
            } else if(A[mid][col] < A[mid + 1][col]) {
                low = mid + 1;
            } else {
                ans.add(mid);
                ans.add(col);
                break;
            }
        }
        return ans;
    }
    int find(int row, int [][]A) {
        int col = 0;
        for(int i = 0; i < A[row].length; i++) {
            if(A[row][i] > A[row][col]) {
                col = i;
            }
        }
        return col;
    }
}
