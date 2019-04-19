package Amazon.RotateImage;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/rotate-image/description
 * 旋转=上下翻转后+交换x,y
 * 顺时针90：先上下，再对角线
 * 逆时针90：先左右，再对角线
 * 本题是顺时针旋转：上下翻转：r,c---->n-1-r,c；对角线翻转【矩阵转置】c,n-1-r。
 * amazon
 */
public class Solution1 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //翻转
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < n; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n - r - 1][c];
                matrix[n - r - 1][c] = tmp;
            }
        }
        //矩阵转置
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
    }
}
