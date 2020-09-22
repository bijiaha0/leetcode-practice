package Amazon.RotateImage;

/**
 * https://www.jiuzhang.com/solutions/rotate-image/
 * <p>
 * 给定一个N×N的二维矩阵表示图像，90度顺时针旋转图像。
 *
 * 旋转方法总结:
 * 1、顺时针90：先上下，再对角线；
 * 2、逆时针90：先左右，再对角线。
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i, j;
        //上下翻转
        for (i = 0; i < row / 2; i++) {
            for (j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - i][j];
                matrix[row - 1 - i][j] = tmp;
            }
        }
        //对角线
        for (i = 0; i < row; i++) {
            for (j = i; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
