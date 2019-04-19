package Amazon.CopyBooks;

/**
 * Email: clickgwas@gmail.com
 * 记忆化搜索
 */
public class Solution2 {
    int[][] f;
    int[] A;
    int n, K;

    void calc(int k, int i) {
        if (f[k][i] != -1) {
            return;
        }

        if (k == 0) {
            f[k][i] = i == 0 ? 0 : Integer.MAX_VALUE;
            return;
        }

        if (i == 0) {
            f[k][i] = 0;
            return;
        }

        f[k][i] = Integer.MAX_VALUE;
        int s = 0;
        for (int j = i; j >= 0; --j) {
            calc(k - 1, j);
            f[k][i] = Math.min(Math.max(s, f[k - 1][j]), f[k][i]);
            if (j > 0) {
                s += A[j - 1];
            }
        }
    }

    public int copyBooks(int[] AA, int KK) {
        A = AA;
        n = A.length;
        K = KK;

        if (n == 0) {
            return 0;
        }

        if (K > n) {
            K = n;
        }

        f = new int[K + 1][n + 1];
        int i, j, k, s;
        for (i = 0; i <= K; ++i) {
            for (j = 0; j <= n; ++j) {
                f[i][j] = -1;
            }
        }

        calc(K, n);
        return f[K][n];
    }
}
