package Amazon.ContinuousSubarraySumII;

import java.util.ArrayList;
import java.util.List;

/*
* https://www.lintcode.com/problem/continuous-subarray-sum-ii/description
* */
public class Solution {
    class Result{
        public int maxSum;
        public int leftIdx, rightIdx;
    }

    // coef = 1: find the maximum non-empty subarray
    // coef = -1: find the maximum non-empty subarray
    // A[i] *= coef
    Result findMax(int[] A, int coef) {
        // Sj        // S{i-1}      // i-1
        int j, nowSum = 0, prevMinSum = 0, prevMinIdx = -1;
        Result res = new Result();
        res.maxSum = Integer.MIN_VALUE;
        for (j = 0; j < A.length; ++j) {
            nowSum += A[j] * coef;
            // Sj- prevMinSum
            if (nowSum - prevMinSum > res.maxSum) {
                res.maxSum = nowSum - prevMinSum;
                res.leftIdx = prevMinIdx; // i - 1
                res.rightIdx = j;
            }

            if (nowSum < prevMinSum) {
                prevMinSum = nowSum;
                prevMinIdx = j;
            }
        }

        return res;
    }

    public List<Integer> continuousSubarraySumII(int[] A) {
        Result max = findMax(A, 1);
        Result min = findMax(A, -1);
        min.maxSum *= -1;

        int totSum = 0;
        for (int i = 0; i < A.length; ++i) {
            totSum += A[i];
        }

        List<Integer> res = new ArrayList<>();
        if (max.maxSum >= totSum - min.maxSum) {
            res.add(max.leftIdx + 1);
            res.add(max.rightIdx);
        }
        else {
            // special case
            if (min.leftIdx == -1 && min.rightIdx == A.length - 1) {
                res.add(max.leftIdx + 1);
                res.add(max.rightIdx);
            }
            else {
                // use complementary interval for min interval
                // [min.leftIdx+1...min.rightIdx]
                // min.rightIdx + 1 ... len-1, 0, 1, ... min.leftIdx
                res.add(min.rightIdx + 1);
                res.add(min.leftIdx);
            }
        }

        return res;
    }

}
