package Amazon.MaximumSubarray;
/**
 * Time: 00:20
 * Email: clickgwas@gmail.com
 * Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
 */
// Version 2: Prefix Sum
public class Solution2 {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录前i个数的和，minSum记录前i个数中0-k的最小值
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
