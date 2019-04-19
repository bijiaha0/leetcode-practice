package Amazon.StoneGame;

public class Solution2 {
    public int stoneGame(int[] A) {
        // Algorithm: Dynamic Programming
        // state: f[start][end] denote the minimum score that we can get if we merge stones from start-th pile to end-th pile into one pile.
        // function: f[start][end] = min{f[start][k] + f[k + 1][end] + sum[start][end]}

        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;

        // initialize f[i][i]
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 0;
        }

        // preparation for sum[i][j]
        int[][] sum = new int[n][n];
        sum[0][0] = A[0];
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        // dp
        // delta is the distance between the start and end
        for (int delta = 1; delta < n; delta++) {
            for (int start = 0; start < n - delta; start++) {
                int end = start + delta;
                //initialize f[start][end]
                f[start][end] = Integer.MAX_VALUE;
                for (int k = start; k < end; k++) {
                    f[start][end] = Math.min(f[start][end], f[start][k] + f[k + 1][end] + sum[start][end]);
                }
            }
        }

        return f[0][n - 1];
    }
}
