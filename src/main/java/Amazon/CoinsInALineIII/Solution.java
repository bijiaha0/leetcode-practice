package Amazon.CoinsInALineIII;
/*
* 因为硬币总价值一定，为了保证 先手最大，保证取完后对手能取到的最小即可。
  dp[i][j] = preSum[j + 1] - preSum[i] - Math.min(dp[i+1][j], dp[i][j-1]);
  实际的流程就是一个 填矩阵 的过程。
  我们发现 dp[i][j] 依赖与 dp[i+1][j] 和 dp[i][j-1] 这两个状态。
  并且 左端位置i 永远不可能大于 右端位置j
  因此我们要填的其实是这个矩阵的 右上部分 的一个三角形。
  而初始化的 base 就是这个矩阵的 对角线。
  按照 从下到上，从左到右 的顺序进行递推，得到最终结果：
  矩阵的 右上角 (dp[0][n-1])
* */
public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[] preSum = new int[n + 1];
        // 计算前缀和以便后面快速计算出各个区间段之和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + values[i - 1];
        }
        // Initialize and Function
        int[][] dp = new int[n][n];
        // bottom to top
        for (int i = n - 1; i >= 0; i--) {
            // left to right
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = values[i];
                } else {
                    int sum = preSum[j + 1] - preSum[i];//前j个硬币的前缀和-前【i-1】个硬币的前缀和。
                    dp[i][j] = sum - Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] > preSum[n] / 2;
    }
}
