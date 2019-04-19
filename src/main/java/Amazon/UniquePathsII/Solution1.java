package Amazon.UniquePathsII;

/**
 * Author: bijiaha0
 * Date: 2019-03-09
 * Time: 10:21
 * Email: clickgwas@gmail.com
 * 记忆化搜索
 */
public class Solution1 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */

    int[][] f;
    int[][] A;
    int m;
    int n;

    void calc(int i, int j) {
        if (f[i][j] != -1) {
            return;
        }

        if (A[i][j] == 1) {
            f[i][j] = 0;
            return;
        }

        if (i == 0 && j == 0) {
            f[i][j] = 1;
            return;
        }

        f[i][j] = 0;
        if (i > 0) {
            calc(i - 1, j);
            f[i][j] += f[i - 1][j];
        }

        if (j > 0) {
            calc(i, j - 1);
            f[i][j] += f[i][j - 1];
        }
    }

    public int uniquePathsWithObstacles(int[][] AA) {
        A = AA;
        m = A.length;
        if (m == 0) {
            return 0;
        }

        n = A[0].length;
        if (n == 0) {
            return 0;
        }

        int i, j;
        f = new int[m][n];
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                f[i][j] = -1;
            }
        }

        calc(m - 1, n - 1);
        return f[m - 1][n - 1];
    }
}
