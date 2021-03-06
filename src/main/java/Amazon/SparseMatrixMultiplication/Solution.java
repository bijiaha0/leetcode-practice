package Amazon.SparseMatrixMultiplication;
import java.util.ArrayList;
import java.util.List;
/**
 * Email: clickgwas@gmail.com
 * 矩阵乘法----->稀疏矩阵乘法
 * https://www.lintcode.com/problem/sparse-matrix-multiplication/description
 * linkin
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        // 矩阵A的列数和矩阵B的行数相等
        int n = A.length;
        int t = A[0].length;
        int m = B[0].length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < t; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    public int[][] multiply1(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    public int[][] multiply2(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        int[][] C = new int[n][m];
        List<List<Integer>> col = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            col.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (B[i][j] != 0) {
                    col.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j: col.get(k)) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
