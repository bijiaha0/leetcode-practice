package Amazon.StoneGame;
/*
*
*递推
* */
public class Solution1 {

    public int stoneGame(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][A.length];
        int[] sums = new int[A.length + 1];
        sums[0] = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = 0;
            sums[i+1] = sums[i] + A[i];
        }

        return search(0, A.length - 1, dp, sums);
    }

    private int search(int start, int end, int[][] dp, int[] sums) {
        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int left = search(start, k, dp, sums);
            int right = search(k + 1, end, dp, sums);
            int now = sums[end+1] - sums[start];
            min = Math.min(min, left + right + now);
        }
        dp[start][end] = min;
        return min;
    }
}
