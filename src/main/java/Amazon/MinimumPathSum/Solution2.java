package Amazon.MinimumPathSum;
/**
 * Email: clickgwas@gmail.com
 */
public class Solution2 {
    public int minPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int m = A.length, n = A[0].length;
        int[][] f = new int[2][n];
        int i, j;
        int old, now = 0; // f[i] is stored in rolling array f[0]
        for (i = 0; i < m; ++i) {
            old = now;
            now = 1 - now; // 0 --> 1, 1 --> 0

            for (j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    f[now][j] = A[0][0];
                    continue;
                }

                f[now][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    f[now][j] = Math.min(f[now][j], f[old][j]);
                }

                if (j > 0) {
                    f[now][j] = Math.min(f[now][j], f[now][j - 1]);
                }

                f[now][j] += A[i][j];
            }
        }

        return f[now][n - 1];
    }
}
