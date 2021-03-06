package Amazon.HouseRobber;
/*
线性DP题目.

设 dp[i] 表示前i家房子最多收益, 答案是 dp[n], 状态转移方程是

dp[i] = max(dp[i-1], dp[i-2] + A[i-1])
考虑到dp[i]的计算只涉及到dp[i-1]和dp[i-2], 因此可以O(1)空间解决.

* */
public class Solution2 {

    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;
        long []res = new long[2];

        res[0] = 0;
        res[1] = A[0];
        for (int i = 2; i <= n; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + A[i-1]);
        }
        return res[n%2];
    }
}
