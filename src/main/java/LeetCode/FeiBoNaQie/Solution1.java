package LeetCode.FeiBoNaQie;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/22 4:15 PM
 * dp 实现
 */
public class Solution1 {

    public int fibonaqie(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


}
