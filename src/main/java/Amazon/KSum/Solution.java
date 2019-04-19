package Amazon.KSum;
/*
* https://www.lintcode.com/problem/k-sum/description
* dp 0-1背包问题
*
* f[i][j][t] 表示的是前i个元素，从中选出j个元素，使得和为t的个数。
* */
public class Solution {
    public int  kSum(int A[], int k, int target) {
        int n = A.length;
        //State
        int[][][] f = new int[n + 1][k + 1][target + 1];
        //Initialization
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        //Function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = 0;
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];//选当前
                    }
                    f[i][j][t] += f[i - 1][j][t];//不选当前
                }
            }
        }
        //Answer
        return f[n][k][target];
    }
}
