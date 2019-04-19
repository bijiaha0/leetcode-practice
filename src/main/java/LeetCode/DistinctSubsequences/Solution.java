package LeetCode.DistinctSubsequences;

/**
 * https://segmentfault.com/a/1190000003481216
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
