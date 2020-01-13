package Amazon.DistinctSubsequences;
public class Solution {
    public int numDistinct(String S, String T) {
        int sL = S.length();
        int tL = T.length();
        //state
        int[][] f = new int[sL+1][tL+1];
        //init
        int i,j;
        for(j =0;j <=tL;j++){
            f[0][j]=0;
        }
        for(i=0;i<=sL;i++){
            f[i][0] = 1;
        }
        //functon
        for(i=1;i<=sL;i++){
            for(j=1;j<=tL;j++){
                f[i][j] = f[i-1][j];
                if(S.charAt(i-1)==T.charAt(j-1)){
                    f[i][j] += f[i-1][j-1];
                }
            }
        }
        //answer
        return f[sL][tL];
    }
}
