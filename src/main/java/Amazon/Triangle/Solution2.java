package Amazon.Triangle;
import java.util.List;
public class Solution2 {
    int minimumTotal(List<List<Integer>> triangle) {
        int[][] triangleArray = new int[triangle.size()][];
        for(int i=0; i < triangle.size(); i++){
            triangleArray[i] = triangle.get(i).stream().mapToInt(j->j).toArray();
        }
        int n = triangleArray.length,res =Integer.MAX_VALUE;
        //state
        int[][] f = new int[n][n];
        //init
        f[0][0] = triangleArray[0][0];
        //function
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    f[i][j] = f[i - 1][j] + triangleArray[i][j];
                    continue;
                }
                if(j == i){
                    f[i][j] = f[i - 1][j-1] + triangleArray[i][j];
                    continue;
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangleArray[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }
}
