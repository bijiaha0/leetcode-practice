package LeetCode.UniqueBinarySearchTrees;
/**
 * Author: bijiaha0
 * Date: 2019-04-19
 * Time: 23:47
 * Email: clickgwas@gmail.com
 * https://segmentfault.com/a/1190000007530934
 */
public class Solution {
    public int numTrees(int n) {
        if(n==0) return 0;
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int root=1;root<=i;root++){
                dp[i]+=dp[root-1]*dp[i-root];
            }
        }
        return dp[n];
    }
}
