package Amazon.CopyBooks;

/**
 * Email: clickgwas@gmail.com
 * 动态规划专题班版本
 */
public class Solution1 {
    public int copyBooks(int[] A, int K) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }

        int i, j, k, sum;

        int[][] f = new int[2][n + 1];
        int old, now = 0;
        for (i = 0; i <= n; ++i) {
            f[now][i] = Integer.MAX_VALUE;
        }

        f[now][0] = 0;
        for (i = 1; i <= K; ++i) {
            old = now;
            now = 1 - now;
            for (j = 0; j <= n; ++j) {
                f[now][j] = Integer.MAX_VALUE;
                sum = 0;
                for (k = j; k >= 0; --k) {
                    if (f[old][k] < Integer.MAX_VALUE) {
                        f[now][j] = Math.min(f[now][j], Math.max(sum, f[old][k]));
                    }

                    if (k > 0) {
                        sum += A[k - 1];
                    }
                }
            }
        }

        return f[now][n];
    }
}
