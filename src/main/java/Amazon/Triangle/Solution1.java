package Amazon.Triangle;
public class Solution1 {
    public final static int  n  = 5;
    public static int[][] A = {{},{},{}};

    public static int dfs(int x, int y){
        if(x == n){
            return 0;
        }
        int left = dfs(x+1,y);
        int right = dfs(x+1,y+1);
        return A[x][y] + Math.min(left,right);
    }
}

