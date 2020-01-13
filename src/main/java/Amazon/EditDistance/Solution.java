package Amazon.EditDistance;
public class Solution {
    public int minDistance(String word1, String word2) {
        //state
        int l1 = word1.length(),l2 = word2.length();
        int[][] f = new int[l1+1][l2+1];
        //init
        int i,j;
        for(i = 0;i <=l1;i++){
            f[i][0] = i;
        }
        for(j = 0; j <=l2;j++){
            f[0][j] =j;
        }
        //function
        for(i=1;i<=l1;i++){
            for(j=1;j<=l2;j++){
                f[i][j] = Integer.MAX_VALUE;
                //add
                f[i][j] = Math.min(f[i][j],f[i][j-1]+1);
                //replace
                f[i][j] = Math.min(f[i][j],f[i-1][j-1]+1);
                //delete
                f[i][j] = Math.min(f[i][j],f[i-1][j]+1);
                //equals
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]);
                }
            }
        }
        //answer
        return f[l1][l2];
    }
}
