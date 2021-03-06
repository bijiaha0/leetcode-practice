package Amazon.SubmatrixSum;
import java.util.HashMap;
import java.util.Map;
/*
* https://www.lintcode.com/problem/submatrix-sum/description
* */
public class Solution {
    public int[][] submatrixSum(int[][] matrix) {
        int[][] result = new int[2][2];
        int M = matrix.length;
        if (M == 0) return result;
        int N = matrix[0].length;
        if (N == 0) return result;
        // pre-compute: sum[i+1][j+1] = sum of submatrix [(0, 0), (i, j)]，
        //预处理，计算左边和上边的和。
        int[][] sum = new int[M+1][N+1];
        for (int j = 0; j <= N; ++j)
            sum[0][j] = 0;
        for (int i = 1; i <= M; ++i)
            sum[i][0] = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; ++j)
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];//往右往下推，多加了一个sum[i][j]，所以要减去。

        for (int l = 0; l < M; l++) {//行
            for (int h = l+1; h <= M; h++) {//行
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = 0; j <= N; j++) {//列
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l;   result[0][1] = k;
                        result[1][0] = h-1; result[1][1] = j-1;
                        return result;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return result;
    }
}
