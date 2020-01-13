package Amazon.Triangle;
import java.util.List;
public class Solution5 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[n][m];
        int i,j;
        for(j=0;j<m;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(i = n-2;i>=0;i--){
            for(j=0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j) +Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
